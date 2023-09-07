package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UserPage extends TestHelperUtility {
	public WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _addButton = "//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath = _addButton)
	private WebElement addButton;

	private final String _deleteButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deleteButton)
	private WebElement deleteButton;

	private final String _editButton = "//i[@class='glyphicon glyphicon-edit']";
	@FindBy(xpath = _editButton)
	private WebElement editButton;

	private final String _searchEmail = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _searchEmail)
	private WebElement searchEmail;

	private final String _userEmailField = "//table[@id='users_table']//tbody//td[4]";
	@FindBy(xpath = _userEmailField)
	private WebElement userEmailField;

	private final String _okButton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _okButton)
	private WebElement okButton;
	
	private final String _noRecordFoundField = "//td[@class='dataTables_empty']";
	@FindBy(xpath = _noRecordFoundField)
	private WebElement noRecordFoundField;
	
	public CreatePage clickOnAddButton() {
		page.clickOnElement(addButton);
		return new CreatePage(driver);
	}

	public void clickOnDeleteButton() {
		wait.waitForElementToBeVisible(driver, deleteButton);
		page.clickOnElement(deleteButton);

	}

	public void clickOkButton() {
		page.clickOnElement(okButton);
	}

	public void setValidEmail(String email) {
		wait.waitForElementToBeVisible(driver, searchEmail);
		page.enterText(searchEmail, email);
	}

	public String getValidEmail() {
		wait.waitForElementToBeVisible(driver, userEmailField);
		String email = page.getElementText(userEmailField);
		return email;

	}
	public String getEmptyTableText() {
		
		wait.waitForElementToBeVisible(driver, noRecordFoundField);
		String emptyText= page.getElementText(noRecordFoundField);
		return emptyText;
	}

	public EditUserPage clickOnEditButton() {
		wait.waitForElementToBeVisible(driver, editButton);
		page.clickOnElement(editButton);
		return new EditUserPage(driver);

	}

}