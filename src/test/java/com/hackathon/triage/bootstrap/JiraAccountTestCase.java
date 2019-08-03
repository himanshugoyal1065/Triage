package com.hackathon.triage.bootstrap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JiraAccountTestCase {

    @Autowired
    private JiraAccount _jiraAccount;

    @Test
    public void testInitMethod() {
        _jiraAccount.init();
    }
}
