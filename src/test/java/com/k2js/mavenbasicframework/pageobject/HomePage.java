package com.k2js.mavenbasicframework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage {
		@FindBy(linkText="REGISTER")
		private WebElement reglink;
		
		@FindBy(name="userName")
		private WebElement uname;
		@FindBy(name="password")
		private WebElement psw;
		@FindBy(name="login")
		private WebElement submit;
		
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getHomePageTitle() {
		return this.driver.getTitle();
	}
	// to go registration page
	/*
	 * public void clickRegLink() { this.reglink.click(); }
	 */
	// Instead of void we return the registration page as below
	public RegistrationPage clickRegLink() {
		this.reglink.click();
		return PageFactory.initElements(this.driver, RegistrationPage.class);
	}
	
	public void enterUserNameDetails(String uname) {
		this.uname.sendKeys(uname);;
	}
	public void enterPasswordDetails(String psw) {
		this.psw.sendKeys(psw);
	}
	public ReservationPage clickSbmmitButton() {
		submit.click();
		return PageFactory.initElements(this.driver,ReservationPage.class);
	}
	
}
