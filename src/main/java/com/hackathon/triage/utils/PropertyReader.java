package com.hackathon.triage.utils;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.Map;
import java.util.Properties;

import static com.hackathon.triage.config.BootstrapConfig.ACCOUNT_PROPERTIES_FILE;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class PropertyReader {

    @Autowired
    private Environment _environment;

    public PropertyReader() {
    }

    public PropertyReader(Environment inEnvironment) {
        _environment = inEnvironment;
    }

    public Map<String, String> getPropertyFileContent(String inPropertyFileName) {
        AbstractEnvironment abstractEnvironment = (AbstractEnvironment) _environment;

        PropertySource propertySource = abstractEnvironment.getPropertySources().get(inPropertyFileName);

        final Properties accountProperties = (Properties) propertySource.getSource();

        System.out.println(accountProperties);

        return Maps.fromProperties(accountProperties);
    }
}
