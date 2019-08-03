package com.hackathon.triage.config;

import com.hackathon.triage.schedule.api.IScheduleTask;
import com.hackathon.triage.schedule.impl.SprintApiCallerScheduleTaskImpl;
import com.hackathon.triage.schedule.impl.SprintApiCallerTaskConfig;
import com.hackathon.triage.schedule.impl.TaskSchedulerTaskImpl;
import com.hackathon.triage.schedule.impl.TestSchedulerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@EnableScheduling
@Import(value = {TestSchedulerConfig.class})
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

    @Bean
    public SprintApiCallerTaskConfig getSpringApiCallerTaskConfig() {
        return new SprintApiCallerTaskConfig(getSprintApiCallerScheduleTaskImpl());
    }

    @Bean(name = "SprintApiCallerScheduleTaskImpl")
    public IScheduleTask getSprintApiCallerScheduleTaskImpl() {
        return new SprintApiCallerScheduleTaskImpl();
    }

    @Bean(name = "testScheduleApiCallerTaskImpl")
    public IScheduleTask getTaskSchedulerTaskImpl() {
        return new TaskSchedulerTaskImpl();
    }
}
