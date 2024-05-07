package com.scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {
	public ContactPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"menu-item-10\"]")
	private WebElement contactLink;

	@FindBy(id = "g3-name")
	private WebElement nameInput;

	@FindBy(id = "g3-email")
	private WebElement emailInput;

	@FindBy(id = "contact-form-comment-g3-message")
	private WebElement commentInput;

	@FindBy(xpath = "//*[@id=\"contact-form-3\"]/form/div/div[4]/button")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"contact-form-success-header\"]")
	private WebElement messageSentElement;

	public void clickContactLink() {
		contactLink.click();
	}

	public void fillContactForm(String name, String email, String comment) {
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		commentInput.sendKeys(comment);
	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public boolean isMessageSentDisplayed() {
		return messageSentElement.isDisplayed();
	}
}
