package com.hackathon.triage.bootstrap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWihoutCommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestWihoutCommandLineRunner.class);

    @MockBean
    private DatabasePolpulator _databasePolpulator;

    @Before
    public void setUp() {
        LOGGER.info("the startup time " + new Date());
    }

    @Test
    public void test() {
        LOGGER.info("the test is running " + new Date());
    }

    @After
    public void tearDown() {
        LOGGER.info("tear down method " + new Date());
    }
}
