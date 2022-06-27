package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
	private By welcomeMessage = By.id("nameofuser");
	
	public HomePage() throws Exception {
	}
	
	public String getWelcomeMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
		return driver.findElement(welcomeMessage).getText();
	}

	public CategoryPage selectCategory(String value) throws Exception {
		By category = By.xpath("//a[@id='itemc' and text()='"+value+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(category));
		driver.findElement(category).click();
		return new CategoryPage();
	}
}