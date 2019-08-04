package com.hackathon.triage.schedule.task.impl;

import com.hackathon.triage.api.IssueRequestMaker;
import com.hackathon.triage.issue.Issue;
import com.hackathon.triage.issue.IssueRepository;
import com.hackathon.triage.schedule.task.api.IScheduleTask;
import com.hackathon.triage.utils.IssueParser;
import com.hackathon.triage.utils.PropertyReader;
import com.hackathon.triage.utils.api.IPropertyFileUpdateConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

import static com.hackathon.triage.config.ApiCallerConfig.API_FILE_NAME;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Service
public class SprintApiCallerScheduleTaskImpl implements IScheduleTask {

    public static Logger LOGGER = LoggerFactory.getLogger(SprintApiCallerScheduleTaskImpl.class);

    @Autowired
    private PropertyReader _propertyReader;

    @Autowired
    private IssueRequestMaker _issueRequestMaker;

    @Autowired
    private IssueParser _issueParser;

    @Autowired
    private IssueRepository _issueRepository;

    @Autowired
    private IPropertyFileUpdateConsumer _propertyFileUpdateConsumer;

    public SprintApiCallerScheduleTaskImpl() {
    }

    public SprintApiCallerScheduleTaskImpl(PropertyReader inPropertyReader, IssueRequestMaker inIssueRequestMaker,
                                           IssueParser inIssueParser, IPropertyFileUpdateConsumer inPropertyFileUpdateConsumer) {
        _propertyReader = inPropertyReader;
        _issueRequestMaker = inIssueRequestMaker;
        _issueParser = inIssueParser;
        _propertyFileUpdateConsumer = inPropertyFileUpdateConsumer;
    }

    @Override
    public void run() {

        LOGGER.error("background job executed ");

        Map<String, String> properties = _propertyReader.getPropertyFileContent(API_FILE_NAME);
        long totalCount = Long.parseLong(properties.get("total"));

        _issueRequestMaker.setMaxSize(1);
        _issueRequestMaker.setStartIndex(1);
        String json = _issueRequestMaker.executeRequest();

        long currentTotalCount = _issueParser.getTotalIssues(json);

        _propertyFileUpdateConsumer.accept(currentTotalCount);

        long newCount = totalCount - currentTotalCount;

        if (newCount == 0 ) {
            return;
        }

        long limitOfIssueRequests = newCount / 1000;
        long remainingIssues = newCount % 1000;
        LongStream.iterate(1, i -> i + 1000).limit(limitOfIssueRequests).parallel().forEach((i) -> {
           /* _issueRequestMaker.setStartIndex((int) i);
            _issueRequestMaker.executeRequest();*/
            saveIssuesInDb((int) i);
        });

        long nearestThousandMultiple = newCount - remainingIssues;

       /* _issueRequestMaker.setStartIndex((int)nearestThousandMultiple);
        _issueRequestMaker.executeRequest();*/
        saveIssuesInDb((int) nearestThousandMultiple);

    }
    private void saveIssuesInDb(int inStartIndex) {
        _issueRequestMaker.setStartIndex(inStartIndex);

        String json = _issueRequestMaker.executeRequest();
        LOGGER.info("the json obtained " + json);


        List<Issue> issues = _issueParser.parseIssuesFromJson(json);
        LOGGER.info("the list of issues obtained " + issues);

        LOGGER.info("saving into database");
        _issueRepository.saveAll(issues);
        LOGGER.info("saved in db");
    }
}
