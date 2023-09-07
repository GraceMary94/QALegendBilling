package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolePage;
import com.qalegendbilling.utilities.ExcelUtility;

public class RoleTest extends Base{
	LoginPage login;
	HomePage home;
	RolePage role;

@Test(priority=1, description="TC_004 Verify valid login",groups= {"Regression"})
public void TC_004_verifyRoleSearch() {
	List<ArrayList<String>>data=ExcelUtility.excelDataReader("Login Page");
	String uname=data.get(0).get(1);
	String pwrd=data.get(1).get(1);
	List<ArrayList<String>>data1=ExcelUtility.excelDataReader("Role Search");//Excel read for role search
	String rname=data1.get(0).get(1);		
	login = new LoginPage(driver);
	login.enterUserName(uname);
	login.enterPassword(pwrd);
	home = login.clickSubmit();
	home.clickUserManagementTab();//clickUserManagementTab
	role = home.clickRolesTab();//clickRolesTab
	role.enterRoleName(rname);		
	String td_Search=role.getSearchValue();
	Assert.assertEquals(rname, td_Search,ErrorMessages.INVALID_ROLE_NAME);
}
}