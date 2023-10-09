package com.qalegendbilling.utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long EXPLICIT_WAIT = 20000;
	public static final long IMPLICIT_WAIT = 20000;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long FLUENT_WAIT = 20;
	public static final long POLLING_TIME = 5;

	public static void setImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}

	public static void setPageLoadWait(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
	}

	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
