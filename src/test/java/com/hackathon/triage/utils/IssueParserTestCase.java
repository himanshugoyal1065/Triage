package com.hackathon.triage.utils;

import com.hackathon.triage.bootstrap.DatabasePolpulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueParserTestCase {

    @MockBean
    private DatabasePolpulator _databasePolpulator;

    @Autowired
    private IssueParser _issueParser;

    @Test
    public void testIssueParser() {
        _issueParser.parseIssuesFromJson(json);
    }

    private String issuesJsonString = "{ \"issues\" : [{ \"argoNumber\" : \"ARGO-201579\", \"summary\" : \"Initialize the YC Emulator Adapter code - Part 1\", \"assignee\" : {\"self\": \"https://jira.navis.com/rest/api/2/user?username=ramuku\",\n" +
            "                    \"name\": \"ramuku\",\n" +
            "                    \"key\": \"ramuku\",\n" +
            "                    \"emailAddress\": \"kumaran.ramu@navis.com\",\n" +
            "                    \"avatarUrls\": {\n" +
            "                        \"48x48\": \"https://jira.navis.com/secure/useravatar?ownerId=ramuku&avatarId=19001\",\n" +
            "                        \"24x24\": \"https://jira.navis.com/secure/useravatar?size=small&ownerId=ramuku&avatarId=19001\",\n" +
            "                        \"16x16\": \"https://jira.navis.com/secure/useravatar?size=xsmall&ownerId=ramuku&avatarId=19001\",\n" +
            "                        \"32x32\": \"https://jira.navis.com/secure/useravatar?size=medium&ownerId=ramuku&avatarId=19001\"\n" +
            "                    },\n" +
            "                    \"displayName\": \"Kumaran Ramu\",\n" +
            "                    \"active\": true,\n" +
            "                    \"timeZone\": \"America/Los_Angeles\"}, \"watchCount\" : 0, \"components\" : [ { \"_id\" : \"18162\", \"name\" : \"ECI\" } ], \"_class\" : \"com.hackathon.triage.issue.Issue\"}]}";

    private String json = "{\"issues\": [\n" +
            "        {\n" +
            "            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,renderedFields\",\n" +
            "            \"id\": \"397485\",\n" +
            "            \"self\": \"https://jira.navis.com/rest/api/2/issue/397485\",\n" +
            "            \"key\": \"ARGO-206052\",\n" +
            "            \"fields\": {\n" +
            "                \"summary\": \"Equipment\",\n" +
            "                \"issuetype\": {\n" +
            "                    \"self\": \"https://jira.navis.com/rest/api/2/issuetype/5\",\n" +
            "                    \"id\": \"5\",\n" +
            "                    \"description\": \"The sub-task of the issue\",\n" +
            "                    \"iconUrl\": \"https://jira.navis.com/secure/viewavatar?size=xsmall&avatarId=18716&avatarType=issuetype\",\n" +
            "                    \"name\": \"Sub-task\",\n" +
            "                    \"subtask\": true,\n" +
            "                    \"avatarId\": 18716\n" +
            "                },\n" +
            "                \"watches\": {\n" +
            "                    \"self\": \"https://jira.navis.com/rest/api/2/issue/ARGO-206052/watchers\",\n" +
            "                    \"watchCount\": 0,\n" +
            "                    \"isWatching\": false\n" +
            "                },\n" +
            "                \"components\": [\n" +
            "                    {\n" +
            "                        \"self\": \"https://jira.navis.com/rest/api/2/component/10000\",\n" +
            "                        \"id\": \"10000\",\n" +
            "                        \"name\": \"Argo\",\n" +
            "                        \"description\": \"Argo module\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"created\": \"2019-08-03T22:57:38.000-0700\",\n" +
            "                \"assignee\": {\n" +
            "                    \"self\": \"https://jira.navis.com/rest/api/2/user?username=sankaka2\",\n" +
            "                    \"name\": \"sankaka2\",\n" +
            "                    \"key\": \"sankaka2\",\n" +
            "                    \"emailAddress\": \"karthikeyan.sankar@navis.com\",\n" +
            "                    \"avatarUrls\": {\n" +
            "                        \"48x48\": \"https://jira.navis.com/secure/useravatar?ownerId=sankaka2&avatarId=20700\",\n" +
            "                        \"24x24\": \"https://jira.navis.com/secure/useravatar?size=small&ownerId=sankaka2&avatarId=20700\",\n" +
            "                        \"16x16\": \"https://jira.navis.com/secure/useravatar?size=xsmall&ownerId=sankaka2&avatarId=20700\",\n" +
            "                        \"32x32\": \"https://jira.navis.com/secure/useravatar?size=medium&ownerId=sankaka2&avatarId=20700\"\n" +
            "                    },\n" +
            "                    \"displayName\": \"Karthikeyan Sankar\",\n" +
            "                    \"active\": true,\n" +
            "                    \"timeZone\": \"Asia/Kolkata\"\n" +
            "                },\n" +
            "                \"status\": {\n" +
            "                    \"self\": \"https://jira.navis.com/rest/api/2/status/10000\",\n" +
            "                    \"description\": \"Newly created issue.\",\n" +
            "                    \"iconUrl\": \"https://jira.navis.com/images/icons/statuses/invisible.png\",\n" +
            "                    \"name\": \"New\",\n" +
            "                    \"id\": \"10000\",\n" +
            "                    \"statusCategory\": {\n" +
            "                        \"self\": \"https://jira.navis.com/rest/api/2/statuscategory/2\",\n" +
            "                        \"id\": 2,\n" +
            "                        \"key\": \"new\",\n" +
            "                        \"colorName\": \"blue-gray\",\n" +
            "                        \"name\": \"To Do\"\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        }]}";
}
