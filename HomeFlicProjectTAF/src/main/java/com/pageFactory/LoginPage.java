package com.pageFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class LoginPage {

	private Pojo objPojo;

	By loc_inp_UserName = By.xpath("//input[@name='email'][@placeholder='Username or Email']");

	By loc_inp_Password = By.xpath("//input[@name='password'][@placeholder='Password']");

	By loc_btn_Login = By.xpath("//button[text()='Log In']");

	By loc_hdr_LoginPage = By.xpath("//h4[text()='Login']");

	By loc_ForgotPasswordLink = By.xpath("//a[text()='Forgot password?']");

	public LoginPage(Pojo pojo) {

		this.objPojo = pojo;
	}

	public void verifyLoginPageHeader() {

		objPojo.getObjWrapperSeleniumFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify login page is displayed.",
				objPojo.getObjWrapperSeleniumFunctions().checkElementDisplayed(loc_hdr_LoginPage));

	}

	public void setUSerID(String strUserName) {
		
		objPojo.getObjUtilities().logReporter("Set USer ID : " + strUserName,
				objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_UserName, strUserName));
	}

	public void setPassword(String strPassword) {
		
		objPojo.getObjUtilities().logReporter("Set Password : " + strPassword,
				objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_Password, strPassword));
	}

	public void clickLogin() {
		objPojo.getObjWrapperSeleniumFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Click Login : ",
				objPojo.getObjWrapperSeleniumFunctions().click(loc_btn_Login));
	}

	public void clickOnForgotPassword() {
		objPojo.getObjWrapperSeleniumFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Click On Forgot Password ",
				objPojo.getObjWrapperSeleniumFunctions().click(loc_ForgotPasswordLink));

	}
}
