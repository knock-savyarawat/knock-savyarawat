package com.testautomation;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/reports", "json:target/reports/cucumber.json",
		},
		//features = "/src/it/resources/com/testautomation/KnockBookTour.feature",
		monochrome = true)

public class CucumberRunnerIT {	
	
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(CucumberRunnerIT.class);
		System.out.println(result.getFailures().toString());
	}
	
}
