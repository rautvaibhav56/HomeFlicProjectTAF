package com.popupFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class ForgotPasswordPage {

	// Moduler Centralized Pop Up Pages

	private Pojo objPojo;

	public ForgotPasswordPage(Pojo pojo) {

		this.objPojo = pojo;
	}

	
	By loc_hrd_ForgotPassword = By.xpath("//h4[text()='Forgot Password']");
	
	By loc_inp_UserName = By.xpath("//input[@id='user_login_forgot']");

	By loc_BtnSubmit = By.xpath("//button[@id='homey_forgetpass']");




	public void verifyForgotPasswordHeader() {
		
		objPojo.getObjWrapperSeleniumFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Verify Forgot Password pop up page is displayed.",
				objPojo.getObjWrapperSeleniumFunctions().checkElementDisplayed(loc_hrd_ForgotPassword));
	}


	
	public void setUSerID(String strUserName) {
		objPojo.getObjWrapperSeleniumFunctions().waitFor(5);
		objPojo.getObjUtilities().logReporter("Set USer ID : " + strUserName,
				objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_UserName, strUserName));
	}
	
	public void clickOnSubmitBtn() {
		objPojo.getObjWrapperSeleniumFunctions().waitFor(3);
		objPojo.getObjUtilities().logReporter("Click On Forgot Password Button ",
				objPojo.getObjWrapperSeleniumFunctions().click(loc_BtnSubmit));
		
	}
	

}
