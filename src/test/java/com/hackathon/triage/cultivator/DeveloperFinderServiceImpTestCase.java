package com.hackathon.triage.cultivator;

import com.hackathon.triage.bootstrap.DatabasePolpulator;
import com.hackathon.triage.cultivator.api.IDeveloperFinderService;
import com.hackathon.triage.cultivator.impl.DeveloperFinderServiceImpl;
import com.hackathon.triage.utils.CounterSortManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeveloperFinderServiceImpTestCase {

    private final static Logger LOGGER = LoggerFactory.getLogger(DeveloperFinderServiceImpTestCase.class);

    @MockBean
    private DatabasePolpulator _databasePolpulator;

    @Autowired
    private IDeveloperFinderService _developerFinderService;

    @Test
    public void testDeveloperFinder() {
        String storyDescription = "Initialize the YC Emulator Adapter code";

        List<CounterSortManager> counterSortManager = _developerFinderService.findDeveloper(storyDescription);

        LOGGER.info("the list is " + counterSortManager);
    }
}
