package com.unicef.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.unicef.base.BasePageObject;
import com.unicef.base.BaseTest;

public class HomePage extends BasePageObject {
	
		private static final String URL = "https://www.market.unicefusa.org/";
		private By searchField = By.id("keywordHeader");
		private By searchClickfield = By.cssSelector("button.btn.btn-primary.keywordButton");
		
		private By IGplateField = By.xpath("//div[@class='container page m-nopad']/div[2]/div[2]/div/a");

		public HomePage(WebDriver driver) {
			super(driver);
		}

		/* Open Home Page */
		public void openHomePage() throws Exception {
			getPage(URL);
			waitForHomePageLoad();
		}

		/* Get Home page Link */
		public String getHomepageLink() {
			return URL;
		}
		
		/* Type and submit search keyword */
		public   void typeAndSubmitKeyword(String keyword) {
			type(searchField, keyword);
			click(searchClickfield);
			
		}
		
		/*public IGHomePage clickIGplate() {
			click(IGplateField);
			return new IGHomePage(driver);
		}*/

		/* Type and submit productID */
		public ItemDetailPage typeAndSubmitProductID(String productID) {
			type(searchField, productID);
			click(searchClickfield);
			return new ItemDetailPage(driver);
		}

		public void waitForHomePageLoad() throws Exception {
			waitForJavascripttoLoad();
		}

		public ItemDetailPage typeAndSubmitProductID1(String productID) {
			// TODO Auto-generated method stub
			return null;
		}
	}
