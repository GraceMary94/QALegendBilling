package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _userAccount = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _userAccount)
	WebElement userAccount;
	
	private final String _signoutField = "//a[text()='Sign Out']";
	@FindBy(xpath = _signoutField)
	WebElement signoutField;

	private final String _loginLink = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _loginLink)
	private WebElement loginLink;

	private final String _userMgtTab = "//span[text()='User Management']";
	@FindBy(xpath = _userMgtTab)
	private WebElement userMgtTab;
	
	private final String _userTab = "//i[@class='fa fa-user']//following-sibling::span";
	@FindBy(xpath = _userTab)
	private WebElement userTab;
	
	private final String _rolesTab = "//i[@class='fa fa-briefcase']//following-sibling::span";
	@FindBy(xpath = _rolesTab)
	private WebElement rolesTab;
	
	private final String _salesCommissionTab = "//i[@class='fa fa-handshake-o']//following-sibling::span";
	@FindBy(xpath = _salesCommissionTab)
	private WebElement salesCommissionTab;
	
	private final String _homeTab = "//a[@href='https://qalegend.com/billing/public/home']//span";
	@FindBy(xpath = _homeTab)
	private WebElement homeTab;
	
	public boolean userMenuIsDisplayed() {
	boolean status =page.isDisplayed(userTab);
	return status;
	}
	public boolean rolesMenuIsDisplayed() {
		boolean status =page.isDisplayed(rolesTab);
		return status;
		}
	public boolean salesMenuIsDisplayed() {
		boolean status =page.isDisplayed(salesCommissionTab);
		return status;
		}
	
	public String getUserAccountName() {
		String accountName = page.getElementText(userAccount);
		return accountName;
	}

	public LoginPage clickSighnoutButton() {
		page.clickOnElement(userAccount);
		wait.waitForElementToBeVisible(driver, signoutField);
		page.clickOnElement(signoutField);
		return new LoginPage(driver);
	}
	public LoginPage clickOnLoginLink() {
		page.clickOnElement(loginLink);
		return new LoginPage(driver);
	}

	public void clickUserManagementTab() {
		page.clickOnElement(userMgtTab);
		wait.waitForElementToBeVisible(driver, salesCommissionTab); // explicit wait is used. wait till sales commission tab gets displayed
	}

	public UserPage clickOnUsers() {
		page.clickOnElement(userTab);
		return new UserPage(driver);
}
	public RolePage clickRolesTab() {//Click on RolesTab
		page.clickOnElement(rolesTab);
		return new RolePage(driver);
	}
	
	public void clickHomeButton() {
		page.clickOnElement(homeTab);
	}

}