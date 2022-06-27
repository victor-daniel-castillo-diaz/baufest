package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
	
	private By signUpTab = By.xpath("//android.view.ViewGroup[@content-desc='button-sign-up-container']");
	private By logInTab = By.xpath("//android.view.ViewGroup[@content-desc='button-login-container']");
	private By emailInput = By.xpath("//android.widget.EditText[@content-desc='input-email']");
	private By passwordInput = By.xpath("//android.widget.EditText[@content-desc='input-password']");
	private By logInButton = By.xpath("//android.view.ViewGroup[@content-desc='button-LOGIN']");
	//private By closeButton = By.xpath("//*[@id='logInModal']//button[@class='close']");
	private By okButton = By.xpath("//android.widget.Button[@text='OK']");

	public LogInPage() throws Exception {
	}
	
	public void setUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
		WebElement input = driver.findElement(emailInput);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(logInButton));
		driver.findElement(logInButton).click();
	}



	public SignUpPage selectSigUpTab() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpTab));
		driver.findElement(signUpTab).click();
		return new SignUpPage();
	}

	public LogInPage selectLogInTab() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logInTab));
		driver.findElement(logInTab).click();
		return new LogInPage();
	}

	/*
	public void clickSignUpButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		driver.findElement(signUpButton).click();
	} */
/* 
	public void clickCloseButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
		driver.findElement(closeButton).click();
	}
*/
	public void clickOkButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(okButton));
		driver.findElement(okButton).click();
	}

}