package com.interview.fizzbuzz.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/fizzbuzz",
        plugin = {"pretty",
                "html:build/reports/cucumber.html",
                "json:build/reports/cucumber.json"},
        tags = "@regression",
        glue = "com.interview.fizzbuzz.features.steps"
)
public class TestRunner {
}
