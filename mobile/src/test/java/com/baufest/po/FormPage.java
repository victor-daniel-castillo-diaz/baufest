package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormPage extends BasePage {
	private By inputField = By.xpath("//android.widget.EditText[@content-desc='text-input']");
	private By switchInput = By.xpath("//android.widget.Switch[@content-desc='switch']");
	private By openDropdown = By.xpath("//android.view.ViewGroup[@content-desc='Dropdown']");
	private By activeButton = By.xpath("//android.view.ViewGroup[@content-desc='button-Active']");
	private By signUpTab = By.xpath("//android.view.ViewGroup[@content-desc='button-sign-up-container']");
	private By logInTab = By.xpath("//android.view.ViewGroup[@content-desc='button-login-container']");

	public FormPage() throws Exception {
	}
	
	public void setInputField(String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputField));
		WebElement input = driver.findElement(inputField);
		input.clear();
		input.sendKeys(value);
	}

	public void clickSwith() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(switchInput));
		driver.findElement(switchInput).click();
	}


	public void selectDropdownOption(String value) {
		By optionDropdown = By.xpath("//android.widget.CheckedTextView[@text='"+value+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(openDropdown));
		driver.findElement(openDropdown).click();
		driver.findElement(optionDropdown).click();
	}

	public void clickActiveButton() {
		By okButton = By.xpath("//android.widget.Button[@text='OK']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeButton));
		driver.findElement(activeButton).click();
		driver.findElement(okButton).click();
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
}