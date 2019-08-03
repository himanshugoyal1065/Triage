package com.hackathon.triage.config;

import com.hackathon.triage.api.RequestMaker;
import com.hackathon.triage.bootstrap.DatabasePolpulator;
import com.hackathon.triage.bootstrap.JiraAccount;
import com.hackathon.triage.utils.PropertyReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Configuration
@PropertySource(value = "classpath:accountDetails/account.properties", name = BootstrapConfig.ACCOUNT_PROPERTIES_FILE)
@Import(value = {ApiCallerConfig.class, IssueConfig.class, NlpConfig.class, ScheduleConfig.class, CultivatorConfig.class})
public class BootstrapConfig {

    public static final String ACCOUNT_PROPERTIES_FILE = "account.properties";

    @Bean
    public JiraAccount getJiraAccount() {
        return new JiraAccount();
    }

    @Bean
    public DatabasePolpulator getDatabasePopulator() {
        return new DatabasePolpulator();
    }

    @Bean
    public PropertyReader getPropertyReader() {
        return new PropertyReader();
    }
}
