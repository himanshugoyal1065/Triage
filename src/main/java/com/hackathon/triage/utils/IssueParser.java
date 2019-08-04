package com.hackathon.triage.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.triage.issue.Issue;
import com.hackathon.triage.issue.JiraComponent;
import com.hackathon.triage.issue.User;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class IssueParser {

    @Autowired
    private ObjectMapper _objectMapper;

    @Autowired
    private JsonUtils _jsonUtils;

    @Nullable
    public List<Issue> parseIssuesFromJson(@NotNull String inJson) {
        List<Issue> issueList = new ArrayList<>();
        Map<String, Object> jsonObject = _jsonUtils.fromJson(inJson);
        List<Map<String, Object>> issues = (List<Map<String, Object>>) jsonObject.get("issues");
        for(Map<String, Object> issue : issues) {
            String argoNumber = (String) issue.get("key");
            String description = (String) issue.get("description");
            Map<String, Object> fields = (Map<String, Object>) issue.get("fields");
            String summary;
            if (fields.isEmpty()) {
                summary = "";
            } else {
                summary = (String) fields.get("summary");
            }
            Map<String, Object> assignee = (Map<String, Object>) issue.get("assignee");
            String userName;
            String email;
            String key;
            String displayName;
            if (assignee == null) {
                userName = null;
                email = null;
                key = null;
                displayName = null;
            } else {
                userName = (String) assignee.get("name");
                email = (String) assignee.get("email");
                key = (String) assignee.get("key");
                displayName = (String) assignee.get("displayName");
            }
            User user = new User(userName, key, email, displayName);

            Map<String, Object> watches = (Map<String, Object>) issue.get("watches");
            int watchCount;
            if (watches == null) {
                watchCount = 0;
            } else {
                watchCount = (int) watches.get("watchCount");
            }

            Issue issueObject = new Issue();

            issueObject.setArgoNumber(argoNumber);
            issueObject.setSummary(summary);
            issueObject.setDescription(description);
            issueObject.setAssignee(user);
            issueObject.setWatchCount(watchCount);
            issueObject.setComponents(Collections.emptyList());

            List<JiraComponent> componentList = new ArrayList<>();
            List<Map<String, Object>> components = (List<Map<String, Object>>) fields.get("components");
            JiraComponent componentObject = new JiraComponent();
            if (components.size() == 0) {
                componentObject.setId(null);
                componentObject.setName(null);
            } else {
                for (Map<String, Object> component : components) {
                    String id = (String) component.get("id");
                    String componentName = (String) component.get("name");

                    componentObject.setId(id);
                    componentObject.setName(componentName);

                    componentList.add(componentObject);
                    System.out.println(issueObject.getComponents().size());
                }
                issueObject.setComponents(new ArrayList<>(componentList));
            }
            issueList.add(issueObject);
            System.out.println("No of Issues parsed ::: " + issueList.size());
        }
        System.out.println("No of Issues Taken ::: " + issues.size());
        return issueList;
    }

    @NotNull
    public long getTotalIssues(@NotNull String inJson) {
        Map<String, Integer> jsonObject = _jsonUtils.fromJson(inJson);
        int totalIssues = jsonObject.get("total");
        return (long) totalIssues;
    }
}
