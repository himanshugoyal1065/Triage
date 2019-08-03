package com.hackathon.triage.issue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackathon.triage.bootstrap.JiraAccount;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    @Indexed
    @JsonProperty(value = "key")
    private String argoNumber;

    private String summary;

    @Indexed
    private String description;

    private User assignee;

//    private int priority;

    private int watchCount;

//    private IssueType type;

//    private Status status;


    private List<JiraComponent> components;

    @Override
    public String toString() {
        return "argoNumber is " + argoNumber + "\n" +
                "description is " + description + "\n" +
                "assignee (user object ) " + assignee.getDisplayName() ;
    }

    public String getArgoNumber() {
        return argoNumber;
    }

    public void setArgoNumber(String argoNumber) {
        this.argoNumber = argoNumber;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public int getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(int watchCount) {
        this.watchCount = watchCount;
    }

    public List<JiraComponent> getComponents() {
        return components;
    }

    public void setComponents(List<JiraComponent> components) {
        this.components = components;
    }
}
