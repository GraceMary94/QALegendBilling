package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class UserManagmentTest extends Base {
	LoginPage login;
	HomePage home;
@Test(priority=1, description="TC_007 Verify the user managment tab is displayed or not",groups= {"Smoke"})
public void TC_007_verifyUserManagementTabsAreDisplayed(){
	List<ArrayList<String>>data=ExcelUtility.excelDataReader("Login Page");
	String uname=data.get(0).get(1);
	String pwrd=data.get(1).get(1);
	login=new LoginPage(driver);
	login.enterUserName(uname);		
	login.enterPassword(pwrd);
	home=login.clickSubmit();  
	home.clickUserManagementTab();
	boolean userMenuStatus = home.userMenuIsDisplayed();
	boolean roleMenuStatus = home.rolesMenuIsDisplayed();
	boolean salesMenuStatus = home.salesMenuIsDisplayed();
	Assert.assertTrue(userMenuStatus, ErrorMessages.USERSUBMENU_NOTFOUND);
	Assert.assertTrue(roleMenuStatus, ErrorMessages.ROLESUBMENU_NOTFOUND);
	Assert.assertTrue(salesMenuStatus, ErrorMessages.SALESSUBMENU_NOTFOUND);
}
}