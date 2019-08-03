package com.hackathon.triage.schedule.impl;

import com.hackathon.triage.schedule.api.IScheduleConfig;
import com.hackathon.triage.schedule.api.IScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public abstract class BaseScheduleTaskExecutor implements IScheduleConfig {

    @Autowired
    @Qualifier("threadPoolTaskScheduler")
    private ThreadPoolTaskScheduler _threadPoolTaskScheduler;

    /**
     * NOP
     */
    public BaseScheduleTaskExecutor() {
    }

    public BaseScheduleTaskExecutor(ThreadPoolTaskScheduler inThreadPoolTaskExecutor) {
        _threadPoolTaskScheduler = inThreadPoolTaskExecutor;
    }


    public void configureTasks(ScheduledTaskRegistrar taskRegistrar, IScheduleTask inScheduleTask, String cronExpression) {
        taskRegistrar.setTaskScheduler(_threadPoolTaskScheduler);
        taskRegistrar.addCronTask(inScheduleTask, cronExpression);
    }
}
