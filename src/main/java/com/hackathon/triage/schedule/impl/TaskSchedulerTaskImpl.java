package com.hackathon.triage.schedule.impl;

import com.hackathon.triage.schedule.api.IScheduleTask;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class TaskSchedulerTaskImpl implements IScheduleTask {

    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        System.out.println("test background job");

        System.out.println(LocalDateTime.now());

        count.incrementAndGet();
        System.out.println(count);

        System.out.println(LocalDateTime.now());
    }
}
