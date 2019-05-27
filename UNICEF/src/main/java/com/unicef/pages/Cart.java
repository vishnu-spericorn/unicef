package com.unicef.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.unicef.base.BasePageObject;

public class Cart extends BasePageObject{
	private static final String URL = "https://www.market.unicefusa.org/bag/";
	private static final By totalCartPriceField = By.xpath("//div[@class='cart-footer']/div[1]/div[1]/div[3]/p/span[2]");
	private static final By firstRemoveItemClickField = By.xpath("(//a[@data-actiontype='basket-removeitem'])[1]");
	private static final By checkoutbottom = By.id("btn-gotocheckout-bottom");

	public Cart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void waitForCarttoload() throws Exception {
	waitForJavascripttoLoad();
	}
	/* Open C3 page */
	public void openCartpage() throws Exception {
		getPage(URL);
		waitForJavascripttoLoad();
	}
	
	/* Click Checkout */
	
	public void clickcheckout() {
		waitForClickabilityOf(checkoutbottom, 10);
		click(checkoutbottom);
	}
	
	/* Get Total Cart Price */
	public String getTotalCartPrice() {
		waitForVisibilityOf(totalCartPriceField, 10);
		return find(totalCartPriceField).getText();
	}
	
	public void clickRemoveItembutton() throws Exception {
		waitForVisibilityOf(firstRemoveItemClickField, 10);
		Thread.sleep(5000);
		click(firstRemoveItemClickField);
	}


}
