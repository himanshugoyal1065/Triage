package com.hackathon.triage.bootstrap;

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

    private final String summaryString = "ECI";
    private final String summarySecond = "N4";
}
