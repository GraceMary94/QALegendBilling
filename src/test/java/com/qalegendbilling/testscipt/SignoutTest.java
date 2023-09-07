package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.SignoutPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class SignoutTest extends Base {
	SignoutPage signout;
	LoginPage login;
	HomePage home;

	@Test(priority=3, description="TC_005 Verify if user navigate to login while click logout button",groups= {"Smoke"})
	public void TC_005_verifySignout() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("Login Page");
		String uname = data.get(0).get(1);
		login = new LoginPage(driver);
		String actTitile = login.loginPageTitle();
		System.out.println(actTitile);
		login.enterUserName(uname);
		String pwrd = data.get(1).get(1);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		login = home.clickSighnoutButton();
		String expTitle = login.loginPageTitle();
		Assert.assertEquals(actTitile, expTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);

	}
}