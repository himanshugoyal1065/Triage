package com.hackathon.triage.utils;

import com.hackathon.triage.utils.api.IPropertyFileUpdateConsumer;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class PropertyFileUpdateConsumerImpl implements IPropertyFileUpdateConsumer {

    private final String file_name = "api/apiRecords.properties";

    @Override
    public void accept(Long inLong) {
        PropertiesConfiguration propertiesConfiguration = null;
        try {
            propertiesConfiguration = new PropertiesConfiguration(file_name);
            propertiesConfiguration.setProperty("total", inLong);
            propertiesConfiguration.save();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
