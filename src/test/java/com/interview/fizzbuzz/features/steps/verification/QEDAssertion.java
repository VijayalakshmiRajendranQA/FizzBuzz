package com.interview.fizzbuzz.features.steps.verification;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
/****
 * Test Assertion.
 */
public class QEDAssertion {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static ResponseSpecification checkStatusCodeAndContentType = new ResponseSpecBuilder().expectStatusCode(200)
                                                                                                 .build();

    public static void validateResponseBody(String expected,
                                            Response actualResponse) throws JsonProcessingException {
        assertEquals(objectMapper.readTree(expected),
                     objectMapper.readTree(actualResponse.asString()));

    }

    public static void validateResponseStatusCode(Response actualResponse) {
        actualResponse.then()
                      .assertThat()
                      .spec(checkStatusCodeAndContentType);
    }
}
