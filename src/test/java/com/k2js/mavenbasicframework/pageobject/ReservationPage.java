package com.k2js.mavenbasicframework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReservationPage {
	@FindBy(xpath = "//table/tbody/tr[1]/td/font/font/b/font/font[contains(text(),'Flight')]/../../../../..")
	private WebElement flightDetails;

	@FindBy(xpath = "//table/tbody/tr[8]/td/font/font/b/font/font[contains(text(),'Preferences')]/../../../../..")
	private WebElement prefrences;

	private WebDriver driver;

	public ReservationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyFlightDetailsText() {
		String flighDetails_text = flightDetails.getText();

		return flighDetails_text.trim();
	}

	public String verifyPrefrencesText() {
		String pref_text = prefrences.getText();
		return pref_text.trim();
	}

}
