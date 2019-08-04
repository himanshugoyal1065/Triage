package com.hackathon.triage.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class JsonUtils {

    @Autowired
    private final ObjectMapper _objectMapper;

    public JsonUtils(ObjectMapper inObjectMapper) {
        _objectMapper = inObjectMapper;
    }

    public <T> T fromJson(String inJson) {

        configureObjectMapper();

        T t = null;
        try {
            t = _objectMapper.readValue(inJson, new TypeReference<T>(){});
        } catch (Exception e) {
            System.out.println("the object mapper failed");
        }
        return t;
    }

    public void configureObjectMapper() {
        _objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        _objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        _objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    }
}
