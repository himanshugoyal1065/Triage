package com.hackathon.triage.bootstrap;

import com.hackathon.triage.issue.Issue;
import com.hackathon.triage.issue.IssueRepository;
import com.hackathon.triage.issue.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueRepositoryTestCase {

    private final static Logger LOGGER = LoggerFactory.getLogger(IssueRepositoryTestCase.class);

    @Autowired
    private IssueRepository _issueRepository;

    @MockBean
    private DatabasePolpulator _databasePopulator;

    @Test
    public void testFindBySummaryContainsIgnoreCase() {
        List<User> usersObtained = _issueRepository.findBySummaryContainsIgnoreCaseAndAssigneeNotNull(summaryString);
        LOGGER.info("the list of users obtained " + usersObtained);

    }

    /*@Test
    public void testFindBySummaryWithMultipleValues() {
        List<User> usersObtained = _issueRepository.findBySummaryContainsIgnoreCase(Arrays.asList(summaryString, summarySecond));
        LOGGER.info("the list obtained is " + usersObtained);
    }*/

    @Test
    public void testFindBySummaryIssueList() {
        List<Issue> ans = _issueRepository.findAllBySummaryContaining(emulatorString);
//       ans.stream().forEach(t -> System.out.println(t.getDisplayName()));
//        ans.stream().filter(t -> t.getAssignee().getDisplayName() != null).forEach(System.out::println);

        System.out.println("Finding \"ARGO-201579\".....");
//        ans.stream().filter(t -> t.getArgoNumber().equals("ARGO-201579")).map(t -> t.getAssignee().getDisplayName() + t.getAssignee().getEmail()).forEach(System.out::println);
        System.out.println("Found \"ARGO-201579\"");
    }

    private final String summaryString = "ECI";
    private final String summarySecond = "N4";
    private final String emulatorString = "Emulator";
}
