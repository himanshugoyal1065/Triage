package com.hackathon.triage.config;

import com.hackathon.triage.cultivator.api.IDeveloperFinderService;
import com.hackathon.triage.cultivator.impl.DeveloperFinderController;
import com.hackathon.triage.cultivator.impl.DeveloperFinderServiceImpl;
import com.hackathon.triage.issue.IssueRepository;
import com.hackathon.triage.nlp.impl.NlpNounProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Configuration
public class CultivatorConfig {

    @Autowired
    private IssueRepository _issueRepository;

    @Autowired
    private NlpNounProvider _nounProvider;

    @Bean
    public IDeveloperFinderService getDeveloperFinderService() {
        return new DeveloperFinderServiceImpl(_issueRepository, _nounProvider);
    }
}
