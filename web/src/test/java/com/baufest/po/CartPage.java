package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

	public CartPage() throws Exception {
	}

	public boolean findProductByName(String value) throws Exception {
		By productTitle = By.xpath("//td[text()='"+value+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		return value.equals(driver.findElement(productTitle).getText());
	}
}