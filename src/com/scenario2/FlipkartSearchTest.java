package com.scenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartSearchTest extends BaseTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void verifyFlipkartPresence() {
		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage(baseUrl);
		Assert.assertTrue(homePage.isFlipkartLogoDisplayed(),
				"Flipkart logo is not present on the left side of the top.");
	}

	@Test(priority = 2)
	public void searchAndVerifyResults() {
		HomePage homePage = new HomePage(driver);
		homePage.goToHomePage(baseUrl);
		homePage.searchForProduct("iphone 14");

		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		int numberOfItemsDisplayed = searchResultsPage.getNumberOfSearchResults();
		System.out.println("Number of items displayed: " + numberOfItemsDisplayed);
		searchResultsPage.clickFirstSearchResult();

		ProductPage productPage = new ProductPage(driver);
		String expectedTitle = "Apple iPhone 14 Plus (Starlight, 128 GB)";

		String actualTitle = productPage.getProductTitle();
		System.out.println("Actual Title: " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle,
				"Navigated to the wrong page or title of the Page is incorrect.");

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
