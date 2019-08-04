package com.hackathon.triage.cultivator.impl;

import com.hackathon.triage.cultivator.api.IDeveloperFinderService;
import com.hackathon.triage.utils.CounterSortManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RestController
@RequestMapping("/find/developer")
public class DeveloperFinderController {

    @Autowired
    private IDeveloperFinderService _developerFinderService;

    /**
     * @param inStoryDescription takes the description of the story
     * @return the appropiate developer
     */
    @PostMapping
    public List<CounterSortManager> getDeveloper(String inStoryDescription) {
        return _developerFinderService.findDeveloper(inStoryDescription);
    }
}
