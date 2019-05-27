package com.unicef.base;


	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class BasePageObject {
 
		protected WebDriver driver;
		protected WebDriverWait wait;
		protected Actions action;

		/* Constructor */
		protected BasePageObject(WebDriver driver) {
			this.driver = driver;
			wait = new WebDriverWait(driver, 40);
		}

		/* Return page for the given URL */
		@SuppressWarnings("unchecked")
		protected void getPage(String url) {
			driver.get(url);
			
		}

		/* For typing in text fields */
		protected void type(By Field, String text) {
			System.out.println("Typing text : " + text);
			driver.findElement(Field).sendKeys(text);
		}

		/* For clicking a target */
		protected void click(By Field) {
			driver.findElement(Field).click();
		}

		/* To get page title */
		public String getPageTitle() {
			return driver.getTitle();
		}

		/* To get inner HTML text of a particular target */
		protected String getText(By Field) {
			return driver.findElement(Field).getText();
		}

		/* To find element */
		public WebElement find(By Field) {
			return driver.findElement(Field);
		} 

		/* Get current cookies */
		protected Set<Cookie> getCurrentCookies() {
			return driver.manage().getCookies();
		}

		/* Delete all cookies */
		protected void deleteAllCookies() {
			driver.manage().deleteAllCookies();
		}

		/* Set cookies to driver given a cookie */
		protected void setCookies(Set<Cookie> cookies) {
			for (Cookie cookie : cookies) {
				driver.manage().addCookie(cookie);
			}
		}

		/* To get count of a particular field */
		protected Integer getFieldCount(By Field) {
			return driver.findElements(Field).size();
		}

		/* Mouse hover and click */
		protected void mouseHoverClick(By target, By clickTarget) {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(target)).perform();
			waitForVisibilityOf(clickTarget, 10);
			waitForClickabilityOf(clickTarget, 10);
			driver.findElement(clickTarget).click();
		}
		
		/* Move mouse to a particular location */
		protected void moveMouse( By target ) {
			action = new Actions(driver);
			action.moveToElement(driver.findElement(target) );
		}

		/* Wait Functionalities */

		/* Wait for javaScript to load */
		public void waitForJavascripttoLoad() throws Exception {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
							.equals("complete");
				}
			};
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		}

		/* Wait for visibility of a particular target */
		protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
			int attempts = 0;
			while (attempts < 2) {
				try {
					waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
							(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
					break;
				} catch (StaleElementReferenceException e) {
					// TODO: handle exception
				}
				attempts++;
			}
		}

		/* Wait until a particular target is clickable */
		protected void waitForClickabilityOf(By locator, Integer... timeOutInSeconds) {
			int attempts = 0;
			while (attempts < 2) {
				try {
					waitFor(ExpectedConditions.elementToBeClickable(locator),
							(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
					break;
				} catch (StaleElementReferenceException e) {
					// TODO: handle exception
				}
				attempts++;
			}
		}

		/* Wait based on condition */
		private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
			timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(condition);
		}

		/* Make driver wait given a time */
		protected void makeDriverWait(Integer seconds) {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		}

	}
