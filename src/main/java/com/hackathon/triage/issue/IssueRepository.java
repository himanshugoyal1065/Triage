package com.hackathon.triage.issue;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {

    //todo optimise this to not return the null records... it takes a lot of time otherwise..
    List<User> findBySummaryContainsIgnoreCaseAndAssigneeNotNull(String inNoun);

    @Query(value = "{'summary': {$regex : ?0, $options: 'i'}}")
    List<Issue> findAllBySummaryContaining(String inNoun);

}
