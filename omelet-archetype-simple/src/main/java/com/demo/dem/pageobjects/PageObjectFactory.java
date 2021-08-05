package com.demo.dem.pageobjects;

import org.openqa.selenium.WebDriver;

import com.springer.omelet.data.IProperty;

/**
 * This is Utility class for the ease in writing code 
 * , always good to have as your page objects are bound to grow in future
 * @author kapil
 *
 */
public class PageObjectFactory {
	
	private WebDriver driver;
	private IProperty prop;
	//Pages 
	private GooglePage googlePage;
	private SeleniumPage seleniumPage;
	
	public PageObjectFactory(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
	}
	public GooglePage googlePage(){
		if(null == googlePage){
			googlePage = new GooglePage(driver,prop);
		}
		return googlePage;
	}
	
	public SeleniumPage seleniumPage(){
		if(null == seleniumPage){
			seleniumPage = new SeleniumPage(driver);
		}
		return seleniumPage;
	}

}
