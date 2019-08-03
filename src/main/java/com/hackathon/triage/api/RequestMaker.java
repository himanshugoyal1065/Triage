package com.hackathon.triage.api;

import com.hackathon.triage.bootstrap.JiraAccount;
import com.hackathon.triage.utils.TriageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public abstract class RequestMaker {

    @Autowired
    private JiraAccount _jiraAccount;

    protected abstract String getUri();

    public String executeRequest() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(getUri(), HttpMethod.GET, getHttpEntity(), String.class);
        return responseEntity.getBody();
    }

    protected HttpHeaders getHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(_jiraAccount.getValueForProperty(TriageConstants.username),
                _jiraAccount.getValueForProperty(TriageConstants.password));
        return headers;
    }

    public HttpEntity getHttpEntity() {
        return  new HttpEntity<>("parameters", getHttpHeader());
    }
}
