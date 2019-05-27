package com.unicef.base;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class WebPageUtility {

	public static String captureScreenShots(WebDriver driver, String testname) throws URISyntaxException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String path = new WebPageUtility().pwd();
		String pathname = path + "/src/test/resources/screenshots/" + testname + formater.format(calendar.getTime())
				+ ".png";
		String relativePath = "../screenshots/" + testname + formater.format(calendar.getTime()) + ".png";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(pathname));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshots " + e.getMessage());
		}
		return relativePath;

	}

	public String pwd() throws URISyntaxException {
		        
		        String cwd = System.getProperty("user.dir");
		        System.out.println("Current working directory : " + cwd);
				return cwd;
	}

	/* Generate a random number given limit */
	public int generateRandomNumber(Integer low, Integer high) {
		Random r = new Random();
		return r.nextInt(high - low) + low;
	}

	
}
