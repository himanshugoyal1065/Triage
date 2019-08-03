package com.hackathon.triage.schedule;

import com.hackathon.triage.config.ScheduleConfig;
import com.hackathon.triage.schedule.impl.TaskSchedulerTaskImpl;
import com.hackathon.triage.schedule.impl.TestSchedulerConfig;
import org.awaitility.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ScheduleConfig.class})
public class TaskSchedulerTaskImplTestCase {

    @MockBean
    private TestSchedulerConfig _testMockBean;

    @Test
    public void testTask() {
        await().
                atMost(Duration.FIVE_SECONDS).
                untilAsserted(() -> verify(_testMockBean, times(5)));

    }
}
