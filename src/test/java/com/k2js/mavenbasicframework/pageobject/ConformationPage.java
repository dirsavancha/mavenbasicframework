package com.k2js.mavenbasicframework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConformationPage {
	
	@FindBy(xpath="//td/p[1]/font/../..")
	private WebElement conformationMessage;
	
	
	private WebDriver driver;
	public ConformationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getconformationtext() {
		String cmsg=conformationMessage.getText();
		return cmsg;
	}
	

}
