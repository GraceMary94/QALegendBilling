package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.listeners.Retry;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
	UserPage user;
	CreatePage create;
	
	@Test(priority=1,enabled=true, description="TC_001 Verify valid login",groups= {"Regression"},retryAnalyzer=Retry.class)
	public void TC_001_verifyValidLogin() {
		List<ArrayList<String>>data=ExcelUtility.excelDataReader("Login Page");
		String uname=data.get(0).get(1);
		String pwrd=data.get(1).get(1);
		String expUserName=data.get(3).get(1);
		login=new LoginPage(driver);
		login.enterUserName(uname);		
		login.enterPassword(pwrd);
		home=login.clickSubmit();     
		String actualUserName=home.getUserAccountName();
		Assert.assertEquals(expUserName, actualUserName,ErrorMessages.USERNAME_FAILURE_MESSAGE);
		
	}
	@Test(priority=1, description="TC_002 Verify invalid login",groups= {"Regression"},dataProvider = "InvalidUserCredentials",dataProviderClass = DataProviders.class)
	public void TC_002_verifyInvalidLogin(String userName, String password)
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("Login Page");
		String exp_ErrorMsg = data.get(4).get(1);
		home = new HomePage(driver);
		login = home.clickOnLoginLink();
		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickOnSubmitButton();
		String actErrorMsg = login.getErrorMessage();
		Assert.assertEquals(exp_ErrorMsg, actErrorMsg,ErrorMessages.INVALID_LOGIN);
		
	}
	@Test(priority=1,description="TC_010 Verify user login with newly added user",groups= {"Regression"})
	public void TC_010_verifyLoginUsingNewlyAddedUser() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("Login Page");
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("Add User");
		String prefix = data1.get(0).get(1);
		String firstName = RandomUtility.getfName();
		String lastName = RandomUtility.getlName();
		String email = RandomUtility.getRandomEmail();
		String userName = firstName + lastName;
		String password = firstName + "@123";
		String confirmPassword = password;
		String salesCommissionPercentage = data1.get(8).get(1);

		login = new LoginPage(driver);
		String actTitile = login.loginPageTitle();
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();
		user = home.clickOnUsers();
		create = user.clickOnAddButton();
		create.enterUserDetails(prefix, firstName, lastName, email, userName, password, confirmPassword, salesCommissionPercentage);
		create.clickOnIsActive();
		user=create.clickOnSaveButton();
		user.setValidEmail(email);
		String actEmail = user.getValidEmail();
		Assert.assertEquals(email, actEmail, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);
		home.clickHomeButton();
		login = home.clickSighnoutButton();
		String expTitle = login.loginPageTitle();
		Assert.assertEquals(actTitile, expTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);

		login.enterUserName(userName);		
		login.enterPassword(password);
		home=login.clickSubmit1();     
		String actualUserName=home.getUserAccountName();
		String expUserName=firstName +" "+ lastName;
		Assert.assertEquals(expUserName, actualUserName,ErrorMessages.USERNAME_FAILURE_MESSAGE);
	}
	
}

