package com.baufest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends BasePage {
	
	public CategoryPage() throws Exception {
	}

	public ProductPage selectProduct(String value) throws Exception {
		By product = By.xpath("//a[@class='hrefch' and text()='"+value+"']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		driver.findElement(product).click();
		return new ProductPage();
	}
}