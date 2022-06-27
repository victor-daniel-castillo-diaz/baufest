package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
	private By addToCarButton = By.xpath("//a[text()='Add to cart']");
	
	public ProductPage() throws Exception {
	}

	public ProductPage clickAddToCarButton() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCarButton));
		driver.findElement(addToCarButton).click();
		return this;
	}
}