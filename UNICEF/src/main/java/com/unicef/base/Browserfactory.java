package com.unicef.base;


	import java.net.URISyntaxException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import com.unicef.base.WebPageUtility;


public class Browserfactory {

		public static WebDriver getDriver(Integer browser) throws URISyntaxException {

			WebDriver driver;
			String path = new WebPageUtility().pwd();
			String geckodriver = "geckodriver.exe";
			String chromedriver = "chromedriver.exe";
			String osType = System.getProperty("os.name");
			if (osType.equals("Linux")) {
				geckodriver = "geckodriver";
				chromedriver = "chromedriver";
			}
			switch (browser) {
			// For firefox
			case 2:
				System.setProperty("webdriver.gecko.driver", path + "/src/main/resources/" + geckodriver);
				driver = new FirefoxDriver();
				break;
			// For chrome
			case 1:
				System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/" + chromedriver);
				driver = new ChromeDriver();
				break;
			// For Firefox
			default:
				System.setProperty("webdriver.gecko.driver", path + "/src/main/resources/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			}
			driver.manage().window().maximize();
			return driver;
		}

	}



