package com.demo.dem.test.datatest;

import org.testng.annotations.Test;

import com.springer.omelet.data.IProperty;
import com.springer.omelet.data.driverconf.IBrowserConf;
import com.springer.omelet.driver.Driver;
import com.springer.omelet.testng.support.SAssert;
import com.demo.dem.pageobjects.PageObjectFactory;


public class GoogleTest {

	SAssert sassert = new SAssert();

	@Test(description = "verify if Selenium title is as expected", 
			dataProviderClass = com.springer.omelet.data.DataProvider.class, dataProvider = "XmlData",enabled=true)
	public void verifySeleniumTitle(IBrowserConf browserConf, IProperty testData) {
		PageObjectFactory pof = new PageObjectFactory(Driver.getDriver(browserConf), testData);
		
		pof.googlePage().loadFromProperty().isLoaded().search("Selenium").clickOnLink(0);
		// Selenium
		
		sassert.assertEquals(pof.seleniumPage().isLoaded().getTitle(),
				testData.getValue("Selenium_Title"),
				"Check for the title of the page");
		sassert.assertAll();
	}



}
