package com.hackathon.triage.schedule.configs.impl;

import com.hackathon.triage.schedule.task.api.IScheduleTask;
import com.hackathon.triage.schedule.task.impl.TaskSchedulerTaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Configuration
public class TestSchedulerConfig extends AbstractBaseScheduleTaskExecutor {

    private IScheduleTask _taskSchedulerTask;

    /**
     * NOP
     *
     * @param iScheduleTask TaskSchedulerTaskImpl
     */
    public TestSchedulerConfig(TaskSchedulerTaskImpl iScheduleTask) {
        super(iScheduleTask);
    }


    @Override
    public String getCronExpression() {
        return "0/10 0 0 ? * *";
    }

}
