package com.hackathon.triage.schedule.impl;

import com.hackathon.triage.schedule.api.IScheduleConfig;
import com.hackathon.triage.schedule.api.IScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class SprintApiCallerTaskConfig extends BaseScheduleTaskExecutor implements IScheduleConfig {

    @Autowired
    @Qualifier("SprintApiCallerScheduleTaskImpl")
    private IScheduleTask _sprintApiCallerScheduleTask;

    public SprintApiCallerTaskConfig() {
    }

    public SprintApiCallerTaskConfig(IScheduleTask inScheduleTask) {
        _sprintApiCallerScheduleTask = inScheduleTask;
    }

    /**
     * the cron expression is not correct.. This indicates each thursday at 12 am
     * @return the expression
     */
    @Override
    public String getCronExpression() {
        return "0 0 0 ? * THU";
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        configureTasks(taskRegistrar, _sprintApiCallerScheduleTask, getCronExpression());
    }
}
