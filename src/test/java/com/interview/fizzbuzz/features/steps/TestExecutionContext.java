package com.interview.fizzbuzz.features.steps;

import io.restassured.response.Response;
/****
 * Shares Test execution context between features steps.
 */
public class TestExecutionContext {
    private String postRequest;
    private Response postResponse;
    private String baseUri;
    private String endpointPath;


    public String getPostRequest() {
        return postRequest;
    }

    public void setPostRequest(String postRequest) {
        this.postRequest = postRequest;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getEndpointPath() {
        return endpointPath;
    }

    public void setEndpointPath(String endpointPath) {
        this.endpointPath = endpointPath;
    }

    public Response getPostResponse() {
        return postResponse;
    }

    public void setPostResponse(Response postResponse) {
        this.postResponse = postResponse;
    }
}
