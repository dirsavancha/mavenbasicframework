package com.k2js.mavenbasicframework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationPage {
	@FindBy(name = "firstName")
	private WebElement fnTextBox;
	@FindBy(name = "lastName")
	private WebElement lastname;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(id = "userName")
	private WebElement email;

	@FindBy(name = "address1")
	private WebElement addres1;

	@FindBy(name = "address2")
	private WebElement addres2;

	@FindBy(name = "city")
	private WebElement city;
	@FindBy(name="state")
	private WebElement state;
	
	@FindBy(name="postalCode")
	private WebElement postal;
	
	@FindBy(name="country")
	private WebElement dropdowncountry;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement conformpswd;
	@FindBy(name="register")
	private WebElement submit;

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFirstName(String fname) {
		fnTextBox.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void enterMobileNumber(String mobile) {
		phone.sendKeys(mobile);
	}
	
	public void enterEmailId(String mail) {
		email.sendKeys(mail);
	}

	public void enterAdress_1(String address1) {
		addres1.sendKeys(address1);
	}
	
	public void enterCity(String cty) {
		city.sendKeys(cty);
	}
	
	public void enterState(String st) {
		state.sendKeys(st);
	}
	
	public void enterpostalCode(String pcode) {
		postal.sendKeys(pcode);
	}
	
	public void enterCountry(String country) {
		Select sel=new Select(dropdowncountry);
		sel.selectByVisibleText(country);
	}
	
	public void enterUserName(String uname) {
		userName.sendKeys(uname);
	}
	
	public void enterPasword(String pswd) {
		password.sendKeys(pswd);
	}
	public void enterConformPassword(String cpswd) {
		conformpswd.sendKeys(cpswd);
	}
	
	public ConformationPage clickOnSubbmitButton() {
		submit.click();
		return PageFactory.initElements(driver, ConformationPage.class);
	}
}
