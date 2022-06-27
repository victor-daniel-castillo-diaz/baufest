package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {
	private By userNameInput = By.id("sign-username");
	private By passwordInput = By.id("sign-password");
	private By signUpButton = By.xpath("//button[@onclick='register()']");
	private By closeButton = By.xpath("//*[@id='signInModal']//button[@class='close']");

	public SignUpPage() throws Exception {
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

	public void clickSigUpButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		driver.findElement(signUpButton).click();
	}

	public void clickCloseButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
		driver.findElement(closeButton).click();
	}

}