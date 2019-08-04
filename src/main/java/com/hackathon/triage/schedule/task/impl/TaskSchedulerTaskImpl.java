package com.hackathon.triage.schedule.task.impl;

import com.hackathon.triage.schedule.task.api.IScheduleTask;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Service
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
