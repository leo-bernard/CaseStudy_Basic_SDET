package com.scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
		 * ChromeDriver(options);
		 */
		driver.manage().window().maximize();

	}

	@Test
	public void testContactFormSubmission() {
		driver.get(baseUrl);

		ContactPage contactPage = new ContactPage(driver);
		contactPage.clickContactLink();

		contactPage.fillContactForm("John Doe", "johndoe@example.com", "This is a test comment.");
		contactPage.clickSubmitButton();

		Assert.assertTrue(contactPage.isMessageSentDisplayed());
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
