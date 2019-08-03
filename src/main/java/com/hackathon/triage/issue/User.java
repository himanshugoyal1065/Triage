package com.hackathon.triage.issue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty(value = "name")
    String name;

    @JsonProperty(value = "key")
    String key;

    @JsonProperty(value = "emailAddress")
    String email;

    @JsonProperty(value = "displayName")
    String displayName;

    public User() {
    }

    public User(String name, String key, String email, String displayName) {
        this.name = name;
        this.key = key;
        this.email = email;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
