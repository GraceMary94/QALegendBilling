package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UserPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class EditUserTest extends Base{
	LoginPage login;
	HomePage home;
	UserPage users;
	EditUserPage edit;
	CreatePage create; 
	
	@Test
	public void TC_009_verifyEditPageTab() {
		
			List<ArrayList<String>> data = ExcelUtility.excelDataReader("Login Page");
			String uname = data.get(0).get(1);
			String pwrd = data.get(1).get(1);
			List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("Add User");
			String prefix = data1.get(0).get(1);
			String firstName = RandomUtility.getfName();
			String lastName = RandomUtility.getlName();
			String email = RandomUtility.getRandomEmail();
			String updateEmail = RandomUtility.getRandomEmail();
			String userName = firstName + lastName;
			String password = firstName + "@123";
			String confirmPassword = password;
			String salesCommissionPercentage = data1.get(8).get(1);
			
			login = new LoginPage(driver);
			login.enterUserName(uname);
			login.enterPassword(pwrd);
			home = login.clickSubmit();
			home.clickUserManagementTab();
			users = home.clickOnUsers();
			create = users.clickOnAddButton();
			create.enterUserDetails(prefix, firstName, lastName, email, userName, password, confirmPassword, salesCommissionPercentage);
			create.clickOnIsActive();
			users=create.clickOnSaveButton();
			users.setValidEmail(email);
			edit=users.clickOnEditButton();
			edit.editUserDetails(updateEmail);
			users=edit.clickOnUpdateButton();
			users.setValidEmail(updateEmail);
			String actEmail = users.getValidEmail();
			Assert.assertEquals(updateEmail, actEmail, ErrorMessages.UPDATE_ERROR_MESSAGE);
			
	
		
}
}