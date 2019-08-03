package com.hackathon.triage.config;

import com.hackathon.triage.api.IssueRequestMaker;
import com.hackathon.triage.utils.PropertyFileUpdateConsumerImpl;
import com.hackathon.triage.utils.api.IPropertyFileUpdateConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@PropertySource(value = "classpath:api/apiRecords.properties", name = ApiCallerConfig.API_FILE_NAME)
public class ApiCallerConfig  {

    public static final String API_FILE_NAME = "api.properties";

    @Bean
    public IssueRequestMaker getIssueRequestMaker() {
        return new IssueRequestMaker();
    }

    @Bean
    public IPropertyFileUpdateConsumer getPropertyFileUpdateConsumer() {
        return new PropertyFileUpdateConsumerImpl();
    }
}
