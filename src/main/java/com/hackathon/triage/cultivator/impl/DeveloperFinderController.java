package com.hackathon.triage.cultivator.impl;

import com.hackathon.triage.cultivator.api.IDeveloperFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String getDeveloper(String inStoryDescription) {
        return null;
    }
}
