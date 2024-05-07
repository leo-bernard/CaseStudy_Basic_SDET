package com.scenario2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected WebDriver driver;
	protected String baseUrl = "https://www.flipkart.com/";

	@BeforeSuite
	public void setUpSuite() {
		// Set ChromeDriver path
		System.setProperty("webdriver.chrome.driver",
				"//Users/leobernard/eclipse-workspace/caseStudy_Basic_SDET/Drivers/chromedriver");
		System.setProperty("webdriver.http.factory", "jdk-http-client");

	}
}
