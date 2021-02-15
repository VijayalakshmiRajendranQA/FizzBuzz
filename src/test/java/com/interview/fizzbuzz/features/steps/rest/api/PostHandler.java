package com.interview.fizzbuzz.features.steps.rest.api;

import com.interview.fizzbuzz.Endpoint;
import com.interview.fizzbuzz.features.steps.TestExecutionContext;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/****
 * Rest API post call handler.
 */
public class PostHandler {
    public static RequestSpecification requestSpecification = RestAssured.given()
                                                                         .log()
                                                                         .all()
                                                                         .relaxedHTTPSValidation()
                                                                         .contentType(ContentType.JSON)
                                                                         .urlEncodingEnabled(false);

    public static Response callAPI(TestExecutionContext testExecutionContext) {
        requestSpecification.baseUri(testExecutionContext.getBaseUri())
                            .basePath(Endpoint.FizzBuzz.value())
                            .body(testExecutionContext.getPostRequest());
        return requestSpecification.post();

    }
}
