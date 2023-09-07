package com.qalegendbilling.testscipt;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class ResetTest extends Base {
	ResetPage reset;
	LoginPage login;

	@Test(priority=2, description="TC_003 Verify the rest link is working or notn",groups= {"Sanity"})
	public void TC_003_verifyReset() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("Reset Page");
		String email = data.get(0).get(1);
		String act_ErrorMsg = data.get(1).get(1);
		login = new LoginPage(driver);
		reset = login.clickforgot();
		reset.getEmail(email);
		reset.clickResetLinkButton();
		String expEmailMsg = reset.EmailMessage();
		Assert.assertEquals(expEmailMsg, act_ErrorMsg, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);

	}

}