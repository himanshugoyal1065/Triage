package com.hackathon.triage.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.triage.utils.IssueParser;
import com.hackathon.triage.utils.JsonUtils;
import org.springframework.context.annotation.Bean;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class IssueConfig {
    @Bean
    public IssueParser getIssueParser() {
        return new IssueParser();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public JsonUtils getJsonUtils() {
        return new JsonUtils(getObjectMapper());
    }
}
