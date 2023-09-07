package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qalegendbilling.utilities.TestHelperUtility;

public class RolePage extends TestHelperUtility {
	public WebDriver driver;

	public RolePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _searchBox = "//input[@class='form-control input-sm']";// Finding search box
	@FindBy(xpath = _searchBox)
	WebElement searchBox;
	private final String _rolesField = "//table[@id='roles_table']//tbody//td[1]";// Getting searched data
	@FindBy(xpath = _rolesField)
	WebElement rolesField;

	public void enterRoleName(String role_name) {
		// Searching role name
		wait.waitForElementToBeVisible(driver, searchBox);
		page.enterText(searchBox, role_name);
	}

	public String getSearchValue() {
		wait.waitForElementToBeVisible(driver, rolesField);
		String roleSearch = page.getElementText(rolesField);
		return roleSearch;
	}
}
