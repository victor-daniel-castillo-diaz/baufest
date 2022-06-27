package com.baufest.step;

import com.baufest.po.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonSteps extends BasePage {
	public CommonSteps() throws Exception {
		super();
	}

	@Before
	public void connectDevice() {
		BasePage.setUp();
	}
	
	@After
	public void quitBrowser() {
		BasePage.quit();
	}

	@AfterStep
	public void attachScreenShot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "pass.png");
	}
}