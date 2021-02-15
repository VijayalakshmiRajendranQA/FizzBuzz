package com.interview.fizzbuzz.features.steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.fizzbuzz.Environment;
import com.interview.fizzbuzz.Endpoint;
import com.interview.fizzbuzz.features.steps.rest.api.PostHandler;
import com.interview.fizzbuzz.features.steps.verification.QEDAssertion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/****
 * Feature file Step definition.
 */
public class StepDefinition {
    private TestExecutionContext testExecutionContext;
    private ObjectMapper mapper = new ObjectMapper();

    @Given("^Prepare (.*) post request param (.*)$")
    public void prepareFizzBuzzAPIPostRequest(String endPoint,String rawParam) {
        testExecutionContext = new TestExecutionContext();
        testExecutionContext.setPostRequest(constructJsonRequest(rawParam));
        testExecutionContext.setBaseUri(Environment.PROD_URI.value());
        testExecutionContext.setEndpointPath(resolvePath(endPoint).value());

    }

    @When("^call API")
    public void callFizzBuzzAPI() {
        testExecutionContext.setPostResponse(callApi());
    }

    @Then("^validate API response$")
    public void validateFizzBuzzAPIResponse(DataTable dataTable) throws JsonProcessingException {
        String expectedJson = constructExpectedJson(dataTable);
        QEDAssertion.validateResponseStatusCode(testExecutionContext.getPostResponse());
        QEDAssertion.validateResponseBody(expectedJson,
                                          testExecutionContext.getPostResponse());
    }

    private String constructJsonRequest(String rawParam) {
        List<String> params = Arrays.asList(rawParam.split(","));
        Map<String, List<String>> paramMap = new HashMap<>();
        paramMap.put("values",
                     params);
        try {
            return mapper.writeValueAsString(paramMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Endpoint resolvePath(String path){
       return Endpoint.valueOf(path);
    }

    private String constructExpectedJson(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class,
                                                          String.class);
        try {
            String value = mapper.writeValueAsString(rows);
            if (value != null) {
                value = value.replaceAll("<empty>",
                                 "");
                return value;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Response callApi() {
        // call postHandlerApi
        return PostHandler.callAPI(testExecutionContext);
    }

}
