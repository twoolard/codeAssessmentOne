package com.interview.coding.challenge.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features", glue = "com.interview.coding.challenge.steps", plugin = {"pretty", "html:target/cucumber-reports",  "json:target/cucumber-reports/cucumber.json", "rerun:target/re-run.txt", "junit:target/junit.xml"}, monochrome = true)
public class RunAllTest extends AbstractTestNGCucumberTests {

}
