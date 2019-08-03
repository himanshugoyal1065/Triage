package com.hackathon.triage.schedule.api;

import org.springframework.scheduling.annotation.SchedulingConfigurer;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public interface IScheduleConfig extends SchedulingConfigurer {

    String getCronExpression();

}
