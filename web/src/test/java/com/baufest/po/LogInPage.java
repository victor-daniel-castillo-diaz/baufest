package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
	private By userNameInput = By.id("loginusername");
	private By passwordInput = By.id("loginpassword");
	private By signUpButton = By.xpath("//button[@onclick='logIn()']");
	private By closeButton = By.xpath("//*[@id='logInModal']//button[@class='close']");

	public LogInPage() throws Exception {
	}
	
	public void setUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
		WebElement input = driver.findElement(userNameInput);
		input.clear();
		input.sendKeys(userName);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
		WebElement input = driver.findElement(passwordInput);
		input.clear();
		input.sendKeys(password);
	}

	public void clickLogInButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		driver.findElement(signUpButton).click();
	}

	public void clickCloseButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
		driver.findElement(closeButton).click();
	}

}