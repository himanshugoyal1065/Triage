package com.hackathon.triage.bootstrap;

import com.hackathon.triage.api.IssueRequestMaker;
import com.hackathon.triage.issue.Issue;
import com.hackathon.triage.issue.IssueRepository;
import com.hackathon.triage.utils.IssueParser;
import com.hackathon.triage.utils.api.IPropertyFileUpdateConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.stream.LongStream;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Profile("!test")
public class DatabasePolpulator implements CommandLineRunner {

    public static Logger LOGGER = LoggerFactory.getLogger(DatabasePolpulator.class);

    @Autowired
    private IssueParser _issueParser;

    @Autowired
    private IssueRepository _issueRepository;

    @Autowired
    private IssueRequestMaker _issueRequestMaker;

    @Autowired
    private IPropertyFileUpdateConsumer _propertyFileUpdateConsumer;

    public DatabasePolpulator() {
    }

    public DatabasePolpulator(IssueParser inIssueParser, IssueRepository inIssueRepository,
                              IssueRequestMaker inIssueRequestMaker, IPropertyFileUpdateConsumer inPropertyFileUpdateConsumer) {
        _issueParser = inIssueParser;
        _issueRepository = inIssueRepository;
        _issueRequestMaker = inIssueRequestMaker;
        _propertyFileUpdateConsumer = inPropertyFileUpdateConsumer;
    }

    /**
     * this method hits the required api and fills the database with all the intial values
     * @param args
     * @throws Exception upon error
     */
    @Override
    public void run(String... args) throws Exception {

        _issueRequestMaker.setMaxSize(1);
        String json = _issueRequestMaker.executeRequest();

        long issueCount = _issueParser.getTotalIssues(json);
        LOGGER.info("total number of issues " + issueCount);

        _propertyFileUpdateConsumer.accept(issueCount);

        _issueRequestMaker.setMaxSize(1000);

        long limitOfIssueRequests = issueCount / 1000;
        long remainingIssues = issueCount % 1000;
        LongStream.iterate(1, i -> i + 1000).limit(limitOfIssueRequests).parallel().forEach((i) -> {
           /* _issueRequestMaker.setStartIndex((int) i);
            _issueRequestMaker.executeRequest();*/
           saveIssuesInDb((int) i);
        });

        long nearestThousandMultiple = issueCount - remainingIssues;

       /* _issueRequestMaker.setStartIndex((int)nearestThousandMultiple);
        _issueRequestMaker.executeRequest();*/
       saveIssuesInDb((int) nearestThousandMultiple);
    }

    private void saveIssuesInDb(int inStartIndex) {
        _issueRequestMaker.setStartIndex(inStartIndex);

        String json = _issueRequestMaker.executeRequest();
        LOGGER.info("the json obtained " + json);


        List<Issue> issues = _issueParser.parseIssuesFromJson(json);
        LOGGER.info("the list of issues obtained " + issues.size());

        LOGGER.info("saving into database");
        _issueRepository.saveAll(issues);
        LOGGER.info("saved in db");
    }
}
