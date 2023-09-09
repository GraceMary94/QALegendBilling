package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class UserTest extends Base {
	LoginPage login;
	HomePage home;
	UserPage user;
	CreatePage create;

	@Test(priority=1,description="TC_006 verify add user details",groups= {"Smoke"})
	public void TC_006_verifyAddUserDetails() {
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
		// user added successfully assert or find element of search -then assert using
		// email id or name
		String actEmail = user.getValidEmail();
		Assert.assertEquals(email, actEmail, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);
	}
}