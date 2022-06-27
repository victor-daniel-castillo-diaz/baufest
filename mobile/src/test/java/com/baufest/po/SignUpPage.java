package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {
	private By emailInput = By.xpath("//android.widget.EditText[@content-desc='input-email']");
	private By passwordInput = By.xpath("//android.widget.EditText[@content-desc='input-password']");
	private By confirmPasswordInput = By.xpath("//android.widget.EditText[@content-desc='input-repeat-password']");
	private By signUpButton = By.xpath("//android.view.ViewGroup[@content-desc='button-SIGN UP']");
	private By okButton = By.xpath("//android.widget.Button[@text='OK']");

	public SignUpPage() throws Exception {
	}
	
	public void setEmail(String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
		WebElement input = driver.findElement(emailInput);
		input.clear();
		input.sendKeys(value);
	}

	public void setPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
		WebElement input = driver.findElement(passwordInput);
		input.clear();
		input.sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput));
		WebElement input = driver.findElement(confirmPasswordInput);
		input.clear();
		input.sendKeys(password);
	}

	public void clickSigUpButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
		driver.findElement(signUpButton).click();
	}

	public void clickOkButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(okButton));
		driver.findElement(okButton).click();
	}

}