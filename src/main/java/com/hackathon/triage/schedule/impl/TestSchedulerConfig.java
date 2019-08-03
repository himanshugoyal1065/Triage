package com.hackathon.triage.schedule.impl;

import com.hackathon.triage.schedule.api.IScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Configuration
public class TestSchedulerConfig extends BaseScheduleTaskExecutor{

    @Autowired
    @Qualifier("testScheduleApiCallerTaskImpl")
    private IScheduleTask _taskSchedulerTask;

    @Override
    public String getCronExpression() {
        return "0/10 0 0 ? * *";
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        this.configureTasks(taskRegistrar, _taskSchedulerTask, getCronExpression());
    }
}
