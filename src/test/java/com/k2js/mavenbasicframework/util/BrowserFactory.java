package com.k2js.mavenbasicframework.util;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver driver = null;

	public static WebDriver getBrowser(String bn, String rm) {
		/*
		 * if (rm.equalsIgnoreCase("remote")) { if (bn.equals("chrome")) { String
		 * machineurl = null; ChromeOptions co = new ChromeOptions(); try { machineurl =
		 * CommonUtil.getProperties("config", "ChromeRemoteMachine"); driver = new
		 * RemoteWebDriver(new URL(machineurl), co); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * } if (bn.equalsIgnoreCase("Chrome")) {
		 * 
		 * WebDriverManager.chromedriver().setup();
		 * 
		 * driver = new ChromeDriver(); } else if (bn.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
		 * else if (bn.equalsIgnoreCase("IE")) { WebDriverManager.iedriver().setup();
		 * driver = new InternetExplorerDriver();
		 * 
		 * } }
		 * 
		 * return driver;
		 */
		if (rm.equals("local")) {
			if (bn.equalsIgnoreCase("Chrome")) {
				
				WebDriverManager.chromedriver().setup();	
				driver = new ChromeDriver();
			} else if (bn.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (bn.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			}
		} else if (rm.equalsIgnoreCase("remote")) {
			if (bn.equalsIgnoreCase("Chrome")) {
				ChromeOptions co = new ChromeOptions();
				try {
					driver = new RemoteWebDriver(new URL(""), co);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return driver;

	}

	

	public static void opernUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.close();
	}
}
