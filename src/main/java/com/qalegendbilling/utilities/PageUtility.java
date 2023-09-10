package com.qalegendbilling.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtility {
	public String getPageTitle(WebDriver driver){
	    String title=driver.getTitle();
	    return title;
	}
	public  void clickOnElement(WebElement element){
	    element.click();
	}
	public  void enterText(WebElement element,String text){
	    element.sendKeys(text);
	}
	public String getElementText(WebElement element) {
	    String text = element.getText();
	    return text;
	}

	public void DragAndDrop(WebDriver driver, WebElement source, WebElement destination) {
	    Actions action = new Actions(driver);
	    action.dragAndDrop(source, destination).build().perform();
	}
	
	public Boolean isSelected(WebElement target) {
        boolean selectedStatus = target.isSelected();
        return selectedStatus;
    }
    public boolean isDisplayed(WebElement target) {
        boolean displayStatus = target.isDisplayed();
        return displayStatus;
    }
    
}