package com.unicef.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.unicef.base.BasePageObject;
public class SignIn extends BasePageObject{
	private static final By username = By.id("email");
	private static final By password = By.id("password");
	private static final By signin = By.id("submitReturnLogin");
	
	public SignIn(WebDriver driver) {
		super(driver);
	}
	public void waitForSignIntoload() throws Exception {
		waitForJavascripttoLoad();
	}
	
	public void EntersignInDet() throws Exception {
		waitForVisibilityOf(username, 10);
		type(username, "vishnu.v@spericorn.com");
		type(password, "pass@123");
		click(signin);
		waitForJavascripttoLoad();
		
		
	}
}
