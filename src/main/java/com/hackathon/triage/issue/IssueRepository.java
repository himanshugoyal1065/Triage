package com.hackathon.triage.issue;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {
    List<User> findBySummaryContainsIgnoreCase(List<String> inNouns);
}
