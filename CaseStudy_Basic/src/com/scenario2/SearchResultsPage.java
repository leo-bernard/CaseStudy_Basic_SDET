package com.scenario2;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class=\"BUOuZu\"]")
	private List<WebElement> searchResults;

	public int getNumberOfSearchResults() {
		return searchResults.size();
	}

	public void clickFirstSearchResult() {
		if (!searchResults.isEmpty()) {
			searchResults.get(0).click();
		}
	}
}
