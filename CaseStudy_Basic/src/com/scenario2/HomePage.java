package com.scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@title=\"Flipkart\"]")
	private WebElement flipkartLogo;

	@FindBy(name = "q")
	private WebElement searchBox;

	public void goToHomePage(String url) {
		driver.get(url);
	}

	public boolean isFlipkartLogoDisplayed() {
		return flipkartLogo.isDisplayed();
	}

	public void searchForProduct(String productName) {
		searchBox.sendKeys(productName);
		searchBox.submit();
	}
}
