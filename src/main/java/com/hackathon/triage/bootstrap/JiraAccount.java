package com.hackathon.triage.bootstrap;

import com.hackathon.triage.utils.PropertyReader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static com.hackathon.triage.config.BootstrapConfig.ACCOUNT_PROPERTIES_FILE;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class JiraAccount {

    private final Map<String, String> _jiraAccountDetials = new HashMap<>();

    @Autowired
    private PropertyReader _propertyReader;
    /**
     * NOP
     */
    public JiraAccount() {
    }

    public JiraAccount(PropertyReader inPropertyReader) {
        _propertyReader = inPropertyReader;
    }

    @PostConstruct
    public void init() {
        _jiraAccountDetials.putAll(_propertyReader.getPropertyFileContent(ACCOUNT_PROPERTIES_FILE));
    }

    public String getValueForProperty(String inPropertyName) {
        return _jiraAccountDetials.get(inPropertyName);
    }
}
