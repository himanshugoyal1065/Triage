package com.hackathon.triage.cultivator.impl;

import com.hackathon.triage.cultivator.api.IDeveloperFinderService;
import com.hackathon.triage.issue.Issue;
import com.hackathon.triage.issue.IssueRepository;
import com.hackathon.triage.issue.User;
import com.hackathon.triage.nlp.impl.NlpNounProvider;
import com.hackathon.triage.utils.CounterSortManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<CounterSortManager> findDeveloper(String inStoryDescription) {
        List<String> nouns = _nounProvider.getNouns(inStoryDescription);
        List<Issue> issueList = new ArrayList<>();
        Map<String, CounterSortManager> developersWithRank = new HashMap<>();
        for (String noun : nouns) {
            issueList.addAll(_issueRepository.findAllBySummaryContaining(noun));
        }

        for (Issue issue : issueList) {
            User user = issue.getAssignee();
            if (user.getDisplayName() != null) {
                if (developersWithRank.containsKey(user.getDisplayName())) {
                    CounterSortManager counter = developersWithRank.get(user.getDisplayName());
                    counter.count++;
                    developersWithRank.put(user.getDisplayName(), counter);
                } else {
                    CounterSortManager counter = new CounterSortManager(user.getDisplayName(), 1);
                    developersWithRank.put(user.getDisplayName(), counter);
                }
            }
        }
        List<CounterSortManager> counterList = new ArrayList<>(developersWithRank.values());
        Collections.sort(counterList, (c1, c2) -> c1.count > c2.count ? -1 : c1.count == c2.count ? c1.name.compareTo(c2.name) : 1);
        return counterList;
    }
}
