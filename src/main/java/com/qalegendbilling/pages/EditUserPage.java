package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class EditUserPage extends TestHelperUtility {
	public WebDriver driver;

	public EditUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _isActiveButton = "//input[@class='input-icheck status']";
	@FindBy(xpath = _isActiveButton)
	private WebElement isActiveButton;

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
	
	private final String _updateButton = "//button[@id='submit_user_button']";
	@FindBy(xpath = _updateButton)
	private WebElement updateButton;
	

	public void clickOnIsActiveButton() {

		page.clickOnElement(isActiveButton);

	}

	public void enterPrefix(String prefix) {
		wait.waitForElementToBeVisible(driver, prefixField);
		page.enterText(prefixField, prefix);
	}

	public void enterFirstNameField(String firstName) {
		page.enterText(firstNameField, firstName);
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

	public UserPage clickOnUpdateButton() {

		page.clickOnElement(updateButton);
		return new UserPage(driver);

	}

	public void editUserDetails(String email) {
		wait.waitForElementToBeVisible(driver, emailField);
		emailField.clear();
		wait.waitForElementToBeVisible(driver, emailField);
		page.enterText(emailField, email);
	}
}