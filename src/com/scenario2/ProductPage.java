package com.scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@class=\"KzDlHZ\"]")
	private WebElement productTitle;

	public String getProductTitle() {
		return productTitle.getText();
	}
}
