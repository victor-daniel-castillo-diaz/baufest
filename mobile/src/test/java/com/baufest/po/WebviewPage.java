package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebviewPage extends BasePage {
	private By searchButton = By.xpath("//android.widget.Button[@text='Search']");
	private By searchInput = By.xpath("//android.widget.EditText[@resource-id='docsearch-input']");
	private By cancelButton = By.xpath("//android.widget.Button[@text='Cancel']");
	private By hamburgerMenu = By.xpath("//android.widget.Button[@text='Navigation bar toggle']");

	public WebviewPage() throws Exception {
	}


	public void clickSearchButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
		driver.findElement(searchButton).click();
	}
	
	public void setSearchInput(String value) throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
		WebElement input = driver.findElement(searchInput);
		input.clear();
		input.sendKeys(value);
		Thread.sleep(1000);
	}

	public void clickCancelButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
		driver.findElement(cancelButton).click();
	}

	public void clickHamburgerMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgerMenu));
		driver.findElement(hamburgerMenu).click();
	}

	public void selectTab(String value) throws InterruptedException {
		By tab = By.xpath("//android.view.View[@content-desc='"+value+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(tab));
		driver.findElement(tab).click();
		Thread.sleep(2000);
	}

}