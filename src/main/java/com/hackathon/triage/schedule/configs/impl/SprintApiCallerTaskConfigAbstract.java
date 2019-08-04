package com.hackathon.triage.schedule.configs.impl;

import com.hackathon.triage.schedule.task.api.IScheduleTask;
import com.hackathon.triage.schedule.task.impl.SprintApiCallerScheduleTaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Configuration
public class SprintApiCallerTaskConfigAbstract extends AbstractBaseScheduleTaskExecutor {

    private IScheduleTask _sprintApiCallerScheduleTask;

    public SprintApiCallerTaskConfigAbstract(SprintApiCallerScheduleTaskImpl inScheduleTask) {
        super(inScheduleTask);
        _sprintApiCallerScheduleTask = inScheduleTask;
    }

    /**
     * the cron expression is not correct.. This indicates each thursday at 12 am
     *
     * @return the expression
     */
    @Override
    public String getCronExpression() {
        return "0 0 0 ? * THU";
    }


}
