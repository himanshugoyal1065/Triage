package com.hackathon.triage.cultivator.impl;

import com.hackathon.triage.cultivator.api.IDeveloperFinderService;
import com.hackathon.triage.issue.IssueRepository;
import com.hackathon.triage.nlp.impl.NlpNounProvider;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class DeveloperFinderServiceImpl implements IDeveloperFinderService {

    private IssueRepository _issueRepository;
    private NlpNounProvider _nounProvider;

    public DeveloperFinderServiceImpl(IssueRepository inIssueRepository, NlpNounProvider inNlpNounProvider) {
        _issueRepository = inIssueRepository;
        _nounProvider = inNlpNounProvider;
    }

    @Override
    public String findDeveloper(String inStoryDescription) {
        List<String> nouns = _nounProvider.getNouns(inStoryDescription);

        


        return null;
    }
}
