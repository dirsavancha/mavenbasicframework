package com.k2js.mavenbasicframework.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.grid.config.ConcatenatingConfig;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.k2js.mavenbasicframework.pageobject.ConformationPage;
import com.k2js.mavenbasicframework.pageobject.HomePage;
import com.k2js.mavenbasicframework.pageobject.RegistrationPage;
import com.k2js.mavenbasicframework.pageobject.ReservationPage;
import com.k2js.mavenbasicframework.util.BrowserFactory;
import com.k2js.mavenbasicframework.util.CommonUtil;

public class NewTourRunner {
	WebDriver driver = null;

	@Test
	public void verifyHomePageTitile() throws Throwable {
		String errormsg = "", result = "fail";
		try {
			String bn = CommonUtil.getProperties("config", "browsername");
			System.out.println(bn);
			String rm = CommonUtil.getProperties("config", "runmode");
			System.out.println(rm);
			String url = CommonUtil.getProperties("config", "url");
			System.out.println(url);
			WebDriver driver = BrowserFactory.getBrowser(bn, rm);
			System.out.println(driver);
			BrowserFactory.opernUrl(url);

			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			String act_title = hp.getHomePageTitle();
			System.out.println(act_title);
			String exp_title = CommonUtil.getProperties("homepage", "homepage.titile");
			System.out.println(exp_title);
			// assert exp_title.equalsIgnoreCase(act_title):"Title is not matching";
			Assert.assertEquals(act_title, exp_title, "Error");
			System.out.println("Testcase Completed");
			System.out.println("------------------");

			BrowserFactory.closeBrowser();

		} catch (Throwable t) {
			CommonUtil.takeScreenShot(driver);
			t.printStackTrace();
			errormsg = t.getMessage();
			throw t;
		} finally {
			if (!errormsg.isEmpty())
				System.out.println(errormsg);

			System.out.println(result);

		}
	}

	@Test
	public static void verifyConformationMessage() throws Throwable {
		WebDriver driver = null;
		String errormsg = "", result = "fail";
		try {
			String bn = CommonUtil.getProperties("config", "browsername");
			System.out.println(bn);
			String rm = CommonUtil.getProperties("config", "runmode");
			System.out.println(rm);
			String url = CommonUtil.getProperties("config", "url");
			System.out.println(url);
			driver = BrowserFactory.getBrowser(bn, rm);
			System.out.println(driver);
			BrowserFactory.opernUrl(url);
			HomePage hp = PageFactory.initElements(driver, HomePage.class);
			RegistrationPage rp = hp.clickRegLink();
			String fname = CommonUtil.getProperties("registerpage", "registerpage.firstname");
			System.out.println("First Name is" + fname);
			rp.enterFirstName(fname);
			String lname = CommonUtil.getProperties("registerpage", "registerpage.Lastname");
			rp.enterLastName(lname);
			String mobile = CommonUtil.getProperties("registerpage", "registration.phone");
			rp.enterMobileNumber(mobile);
			String mail = CommonUtil.getProperties("registerpage", "registration.Email");
			rp.enterEmailId(mail);
			String address1 = CommonUtil.getProperties("registerpage", "registration.adress");
			rp.enterAdress_1(address1);

			String cty = CommonUtil.getProperties("registerpage", "registration.city");
			rp.enterCity(cty);
			String st = CommonUtil.getProperties("registerpage", "registration..state/province");
			rp.enterState(st);
			String pc = CommonUtil.getProperties("registerpage", "registration.postalcode");
			rp.enterpostalCode(pc);
			String cnty = CommonUtil.getProperties("registerpage", "registration.country");
			rp.enterCountry(cnty);
			String uname = CommonUtil.getProperties("registerpage", "registration.userName");
			rp.enterUserName(uname);
			String pwd = CommonUtil.getProperties("registerpage", "registration..password");
			rp.enterPasword(pwd);
			String cpwd = CommonUtil.getProperties("registerpage", "registration.conformpassword");
			rp.enterConformPassword(cpwd);
			ConformationPage cp = rp.clickOnSubbmitButton();

			String actualMsg = cp.getconformationtext();
			System.out.println(actualMsg);
			String expcmsg = CommonUtil.getProperties("conformationpage", "conformationpage.conformationmessage");
			System.out.println(expcmsg);
			assert expcmsg.equalsIgnoreCase(actualMsg) : "Conformation message is  not matching";
			result = "pass";

			BrowserFactory.closeBrowser();

		} catch (Throwable t) {
			CommonUtil.takeScreenShot(driver);
			t.printStackTrace();
			errormsg = t.getMessage();
			throw t;
		} finally {
			if (!errormsg.isEmpty())
				System.out.println(errormsg);

			System.out.println(result);

		}

	}

	/*
	 * public static void main(String[] args) throws Throwable { NewTourRunner
	 * ntr=new NewTourRunner(); //ntr.verifyHomePageTitile();
	 * ntr.verifyConformationMessage();
	 * 
	 * }
	 */
	@Test
	public void verifyFlightDetails_Prefrences_Headings() throws Throwable {
		WebDriver driver = null;
		String errormsg = "";
		String result = "Fail";
		try {
			String bn = CommonUtil.getProperties("config", "browsername");
			String rm = CommonUtil.getProperties("config", "runmode");
			String url = CommonUtil.getProperties("config", "url");
			driver = BrowserFactory.getBrowser(bn, rm);
			BrowserFactory.opernUrl(url);

			HomePage hm = PageFactory.initElements(driver, HomePage.class);

			String uname = CommonUtil.getProperties("homepage", "homepage.username");
			hm.enterUserNameDetails(uname);
			String psw = CommonUtil.getProperties("homepage", "homepage.password");
			hm.enterPasswordDetails(psw);
			hm.clickSbmmitButton();
			ReservationPage rp = PageFactory.initElements(driver, ReservationPage.class);

			String actual_flightdetails_text = rp.verifyFlightDetailsText();
			String actual_prefrences_text = rp.verifyPrefrencesText();

			String exp_prefrences_heading = CommonUtil.getProperties("reservationpage", "reservationpage.heading2");
			String exp_fligtDetails_heading = CommonUtil.getProperties("reservationpage", "reservationpage.heading1");

			// assert
			// exp_fligtDetails_heading.equalsIgnoreCase(actual_flightdetails_text):"Not
			// matched";
			// assert exp_prefrences_heading.equalsIgnoreCase(actual_prefrences_text):"Not
			// matched";
			Assert.assertEquals(exp_prefrences_heading, actual_prefrences_text, "Error");
			Assert.assertEquals(exp_fligtDetails_heading, actual_flightdetails_text, "Error");
			result = "pass";

		} catch (Throwable e) {
			CommonUtil.takeScreenShot(driver);
			e.printStackTrace();
			errormsg = e.getMessage();
			throw e;
		} finally {
			if (!errormsg.isEmpty()) {
				System.out.println(errormsg);
				System.out.println(result);
			} else

				BrowserFactory.closeBrowser();
		}
		System.out.println("------------");
	}

}
