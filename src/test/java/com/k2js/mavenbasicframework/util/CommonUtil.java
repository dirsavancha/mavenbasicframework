package com.k2js.mavenbasicframework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtil {
	public static String getProperties(String fn,String key) throws IOException {
		
		try {
			FileInputStream fis=new FileInputStream("TestData/"+fn+".properties");
			
			Properties p=new Properties();
			p.load(fis);
			return p.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	// Method to get current date and time to save the file
	public static String getCurrentDate() {
		String date=LocalDateTime.now().toString();
		
		return date.replace(":", "_").substring(0, date.indexOf('.'));
	}
	
	// Method is to take screen shot
	public static void takeScreenShot(WebDriver driver) {
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src=tss.getScreenshotAs(OutputType.FILE);
		File dest=new File("screenshot/"+getCurrentDate()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// If we want to take screenshot for webElements
	public static void takeScreenShotWebElement(WebElement element) {
		TakesScreenshot tssweb=(TakesScreenshot)element;
		File srcweb=tssweb.getScreenshotAs(OutputType.FILE);
		File destweb=new File("screenshot/"+getCurrentDate()+".png");
		try {
			FileUtils.copyFile(srcweb, destweb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
