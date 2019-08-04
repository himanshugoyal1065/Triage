package com.hackathon.triage.schedule.configs.impl;

import com.hackathon.triage.schedule.configs.api.IScheduleConfig;
import com.hackathon.triage.schedule.task.api.IScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@EnableScheduling
public abstract class AbstractBaseScheduleTaskExecutor implements IScheduleConfig {

    @Autowired
    @Qualifier("threadPoolTaskScheduler")
    private ThreadPoolTaskScheduler _threadPoolTaskScheduler;

    private IScheduleTask iScheduleTask;

    /**
     * NOP
     */
    public AbstractBaseScheduleTaskExecutor(IScheduleTask iScheduleTask) {
        this.iScheduleTask = iScheduleTask;
    }

    private void submitTasksToScheduledThreadPool(ScheduledTaskRegistrar taskRegistrar, IScheduleTask inScheduleTask, String cronExpression) {
        taskRegistrar.setTaskScheduler(_threadPoolTaskScheduler);
        taskRegistrar.addCronTask(inScheduleTask, cronExpression);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        submitTasksToScheduledThreadPool(taskRegistrar, iScheduleTask, getCronExpression());
    }
}
