package com.hackathon.triage.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class JiraComponent {

    @JsonProperty(value = "id")
    String id;

    @JsonProperty(value = "name")
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
