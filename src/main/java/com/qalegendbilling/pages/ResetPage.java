package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class ResetPage extends TestHelperUtility{
	public WebDriver driver;

	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _ResetEmail="//input[@id='email']";
	@FindBy(xpath=_ResetEmail)
	private WebElement resetEmail;
	
	private final String _ResetEmailMsg="//span[@class='help-block']";
	@FindBy(xpath=_ResetEmailMsg)
	private WebElement ResetEmailMsg;
	
	private final String _resetLink="//button[@class='btn btn-primary']";
	@FindBy(xpath=_resetLink)
	private WebElement resetLink;
	
	public void getEmail(String email) {
		page.enterText(resetEmail, email);
	}
	public void clickResetLinkButton() {
		page.clickOnElement(resetLink);
	}
	public String EmailMessage() {
		String msg=page.getElementText(ResetEmailMsg);
		return msg;
	}

}