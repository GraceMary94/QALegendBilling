package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class CreatePage extends TestHelperUtility {
	public WebDriver driver;

	public CreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private final String _isActive = "//input[@class='input-icheck status']";
	@FindBy(xpath = _isActive)
	private WebElement isActive;

	private final String _save = "//button[@id='submit_user_button']";
	@FindBy(xpath = _save)
	private WebElement save;

	private final String _prefixField = "//input[@id='surname']";
	@FindBy(xpath = _prefixField)
	private WebElement prefixField;

	private final String _firstNameField = "//input[@id='first_name']";
	@FindBy(xpath = _firstNameField)
	private WebElement firstNameField;

	private final String _lastNameField = "//input[@id='last_name']";
	@FindBy(xpath = _lastNameField)
	private WebElement lastNameField;

	private final String _emailField = "//input[@id='email']";
	@FindBy(xpath = _emailField)
	private WebElement emailField;

	private final String _userNameField = "//input[@id='username']";
	@FindBy(xpath = _userNameField)
	private WebElement userNameField;

	private final String _passwordField = "//input[@id='password']";
	@FindBy(xpath = _passwordField)
	private WebElement passwordField;

	private final String _confirmPasswordField = "//input[@id='confirm_password']";
	@FindBy(xpath = _confirmPasswordField)
	private WebElement confirmPasswordField;

	private final String _salesCommisionPercentageField = "//input[@id='cmmsn_percent']";
	@FindBy(xpath = _salesCommisionPercentageField)
	private WebElement salesCommisionPercentageField;

	public void clickOnIsActive() {
		page.clickOnElement(isActive);

	}

	public UserPage clickOnSaveButton() {
		page.clickOnElement(save);
		return new UserPage(driver);

	}

	public void enterPrefix(String prefix) {
		wait.waitForElementToBeVisible(driver, prefixField);
		page.enterText(prefixField, prefix);
	}

	public void enterFirstNameField(String firstName) {
		page.enterText(firstNameField, firstName);
	}
	public void enterUserDetails(String prefix, String firstName,String lastName, String email, String username, String password, String confirmPassword, String salesCommissionPercentage) {
		wait.waitForElementToBeVisible(driver, prefixField);
		page.enterText(prefixField, prefix);
		page.enterText(firstNameField, firstName);
		page.enterText(lastNameField, lastName);
		page.enterText(emailField, email);
		page.enterText(userNameField, username);
		page.enterText(passwordField, password);
		page.enterText(confirmPasswordField, confirmPassword);
		page.enterText(salesCommisionPercentageField, salesCommissionPercentage);
	}

	public void enterLastNameField(String lastName) {
		page.enterText(lastNameField, lastName);
	}

	public void enterEmailField(String email) {
		page.enterText(emailField, email);
	}

	public void enterUserNameField(String username) {
		page.enterText(userNameField, username);
	}

	public void enterPasswordField(String password) {
		page.enterText(passwordField, password);
	}

	public void enterConfirmPasswordField(String confirmPassword) {
		page.enterText(confirmPasswordField, confirmPassword);
	}

	public void enterSalesCommissionPercentageField(String salesCommissionPercentage) {
		page.enterText(salesCommisionPercentageField, salesCommissionPercentage);
	}
}