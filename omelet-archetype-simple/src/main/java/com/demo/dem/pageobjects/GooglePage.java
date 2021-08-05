package com.demo.dem.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.springer.omelet.common.ExpectedConditionExtended;
import com.springer.omelet.data.IProperty;
import com.springer.omelet.driver.DriverUtility;
import com.springer.omelet.exception.FrameworkException;



public class GooglePage {
	
	private WebDriver driver;
	private IProperty prop;
	
	@FindBy(name = "q")
	private WebElement searchBar;
	@FindBys(@FindBy(css = ".rc .r a"))
	private List<WebElement> searchReturnLinks;
	
	//Simple Test Contructor
	public GooglePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Constructor to showcase Property use
	public GooglePage(WebDriver driver,IProperty prop){
		this.driver = driver;
		this.prop = prop;
		PageFactory.initElements(driver, this);
	}
	
	public GooglePage load(String url){
		driver.get(url);
		return this;
	}
	
	public GooglePage loadFromProperty(){
		driver.get(prop.getValue("Google_url"));
		return this;
	}
	
	public GooglePage isLoaded(){
		//DriverUtility waitfor is geeric and method and should be used where ever wait condition is required
		if(null == DriverUtility.waitFor(ExpectedConditionExtended.elementToBeClickable(searchBar), driver, 5)){
			throw new FrameworkException("Not able to load Google Home page in 5 seconds");
		}
		return this;
	}
	
	public GooglePage search(String searchText){
		searchBar.sendKeys(searchText+Keys.RETURN);
		return this;
	}
	
	public void clickOnLink(int indexOfTheLink){
		searchReturnLinks.get(indexOfTheLink).click();
	}

}
