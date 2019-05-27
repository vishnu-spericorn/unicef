package com.unicef.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicef.base.BasePageObject;

public class C3category extends BasePageObject {
	
	private static final By productPlate = By.xpath("//div[@id='product-list']/div/div/p[1]/a[1]");

	public C3category(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/* Open c3 page given link*/
	public void openC3pageURL( String c3link ) {
		System.out.println("Opening c3 page : " + c3link);
		getPage(c3link);
	}
	
	/* wait for c3 to load */
	public void waitForC3toLoad() throws Exception {
		waitForJavascripttoLoad();
	}
	
	/* Get product count */
	public int getproductCount() {
		return getFieldCount(productPlate);
	}
	
	/* Get productID of given productPlate */
	public String getProductID(Integer randomeProductPlateNumber) {
		 By currentProductLinkField = By.xpath("//div[@id='product-list']/div[" + randomeProductPlateNumber + "]/div/p[1]/a[1]");
		return driver.findElement(currentProductLinkField).getAttribute("data-linkproductid");
	}
	
	public ItemDetailPage clickProductPlateRandom(Integer randomeProductPlateNumber) throws Exception {
		 By currentproductPlateField = By.xpath("//div[@id='product-list']/div[" + randomeProductPlateNumber + "]/div/p[1]/a[1]");
		click(currentproductPlateField);
		return new ItemDetailPage(driver);
	}

}
