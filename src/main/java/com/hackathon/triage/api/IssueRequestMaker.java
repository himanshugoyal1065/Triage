package com.hackathon.triage.api;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class IssueRequestMaker extends RequestMaker{

    private int _startIndex = 0;
    private int _maxSize = 1000;


    public int getStartIndex() {
        return _startIndex;
    }

    public void setStartIndex(int inStartIndex) {
        this._startIndex = inStartIndex;
    }

    public int getMaxSize() {
        return _maxSize;
    }

    public void setMaxSize(int inMaxSize) {
        this._maxSize = inMaxSize;
    }

    @Override
    protected String getUri() {
        System.out.println("Hitting Api for Batch ::: :" + getStartIndex());
        String url = String.format("https://jira.navis.com/rest/api/2/search?jql=project=10010&fields=categoryKey,summary,statusDescription,created,components,status,watches,issuetype,assignee&maxResults=%s&startAt=%s", getMaxSize() , getStartIndex());
        return url;
    }
}
