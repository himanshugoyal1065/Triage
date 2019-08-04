package com.hackathon.triage.cultivator.api;

import com.hackathon.triage.utils.CounterSortManager;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public interface IDeveloperFinderService {
    List<CounterSortManager> findDeveloper(String inStoryDescription);
}
