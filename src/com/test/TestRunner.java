package com.test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
/**
 * Since BDD has been adopted here to drive testing, all Gherkin related test scenarios
 * could be found in Feature folder. And corresponding implementation could be found
 * in com.test.testStepDefinition package
 * 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"com.test.testStepDefinition"}
		)
public class TestRunner {
 
}
