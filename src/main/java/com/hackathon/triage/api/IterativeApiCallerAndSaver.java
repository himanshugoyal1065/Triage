package com.hackathon.triage.api;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class IterativeApiCallerAndSaver {

    @Autowired
    private IssueRequestMaker _issueRequestMaker;

    public void callAndSaveIssues(long inStartIndex, long inEndIndex) {

    }
}
