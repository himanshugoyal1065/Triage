package com.hackathon.triage.bootstrap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TestWithoutCommandLineInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestWithoutCommandLineInitializer.class);

    @MockBean
    private DatabasePolpulator databasePolpulator;

    @Before
    public void setUp() {
        LOGGER.info("startup time " + new Date());
    }

    @Test
    public void testExectutionTime() {
        LOGGER.info("inside the test case");
    }

    @After
    public void tearDown() {
        LOGGER.info("the time at tear Down " + new Date());
    }
}
