package com.demo.dem.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.springer.omelet.common.ExpectedConditionExtended;
import com.springer.omelet.driver.DriverUtility;
import com.springer.omelet.exception.FrameworkException;


public class SeleniumPage {
	
	private WebDriver driver;
	@FindBy(css = "#header h1 a")
	private WebElement headerText;

	public SeleniumPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SeleniumPage isLoaded(){
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(headerText), driver, 10)){
			throw new FrameworkException("Selenium Home Page is not loaded in 10 seconds");
		}
		return this;
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getHeaderTest(){
		return headerText.getText();
	}
}
