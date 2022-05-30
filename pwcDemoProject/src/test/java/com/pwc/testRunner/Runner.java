package com.pwc.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features ="src/test/resources/Features/FlipCartNavigation.feature"
	,glue = {"com/pwc/stepDefinition"}
	,plugin = {"pretty","html:target/cucumber-reports/reports.html"}
)


public class Runner {

}
