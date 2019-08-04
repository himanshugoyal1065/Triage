package com.hackathon.triage.config;

import com.hackathon.triage.schedule.configs.api.IScheduleConfig;
import com.hackathon.triage.schedule.task.api.IScheduleTask;
import com.hackathon.triage.schedule.task.impl.SprintApiCallerScheduleTaskImpl;
import com.hackathon.triage.schedule.configs.impl.SprintApiCallerTaskConfigAbstract;
import com.hackathon.triage.schedule.task.impl.TaskSchedulerTaskImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Component
@Import(value = {IScheduleConfig.class})
public class ScheduleConfig {

    @Autowired
    private Environment _env;

    @Bean(name = "threadPoolTaskScheduler")
    public ThreadPoolTaskScheduler getThreadPoolTaskScheduler() {
        final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        int threadCount = Integer.parseInt(_env.getProperty("background.job.count"));
        threadPoolTaskScheduler.setPoolSize(threadCount);
        threadPoolTaskScheduler.setThreadNamePrefix("background-job-thread");
        return threadPoolTaskScheduler;
    }
}
