package com.baufest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = {"\\com\\baufest\\step"},
		plugin = {
				"pretty", 
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
				},
		dryRun = false,
		monochrome = true
		)

public class TestRunner {

}
