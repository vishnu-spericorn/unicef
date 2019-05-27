package com.unicef.base;


import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.unicef.base.Browserfactory;
import com.unicef.base.WebPageUtility;
import com.unicef.base.BasePageObject;

public class BaseTest {
	protected WebDriver driver;

	static {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = "./";
		try {
			path = new WebPageUtility().pwd();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	@Parameters({ "browser" })
	@BeforeMethod
	protected void setUp(Integer browser, Method result) throws URISyntaxException {
		new Browserfactory();
		driver = Browserfactory.getDriver(browser);

	}

	@AfterMethod
	protected void tearDown(ITestResult result) throws Exception {

		driver.quit();
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		Reporter.getOutput();
	}
}