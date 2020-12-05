package com.pageFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class RegisterPage {

	private Pojo objPojo;

	public RegisterPage(Pojo pojo) {

		this.objPojo = pojo;

	}

	By loc_hdr_RegisterPage = By.xpath("//h4[text()='Register']");
	By loc_inp_FirstName = By.xpath("//input[@id='firstName']");
	By loc_inp_LastName = By.xpath("//input[@id='lastName']");
	By loc_inp_Email = By.xpath("//input[@id='email']");
	By loc_inp_Phone = By.xpath("//input[@id='register_phone']");
	By loc_inp_Password = By.xpath("//input[@id='password']");
	By loc_inp_UserType = By.xpath("//select[@name='user_type']");
	By loc_btn_Register = By.xpath("//button[text()='Register']");

	public void printTestDatabeanForRegister() {

		objPojo.getObjUtilities().logReporter("Set FirstName :" + objPojo.getObjTestDataBean().getStrFirstName(), true);
		objPojo.getObjUtilities().logReporter("Set Last Name :" + objPojo.getObjTestDataBean().getStrLastName(), true);

	}

	public void verifyRegisterPageHeader() {

		objPojo.getObjWrapperSeleniumFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Verify Register page is displayed.",
				objPojo.getObjWrapperSeleniumFunctions().checkElementDisplayed(loc_hdr_RegisterPage));

	}

	public void setFirstName() {

		objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_FirstName,
				objPojo.getObjTestDataBean().getStrFirstName());
	}

	public void setLastName() {

		objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_LastName,
				objPojo.getObjTestDataBean().getStrLastName());
	}

	public void setEmail() {
		objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_Email,
				objPojo.getObjUtilities().getRandomString(4) + "@yopmail.com");

	}

	public String setPhone(String strPhone) {
		objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_Phone,
				objPojo.getObjUtilities().getRandomNumberString(7) + "678");

		return strPhone;

	}

	/*
	 * public String setPhone(String strPhone) {
	 * objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_Phone,
	 * objConfig.getProperty("strPhone")+objPojo.getObjUtilities().
	 * getRandomNumberString(7));
	 * 
	 * //objRegisterPage.setPhone(objConfig.getProperty("strPhone")+objPojo.
	 * getObjUtilities().getRandomNumberString(7)); return strPhone;
	 * 
	 * 
	 * }
	 */

	public void setPassword(String strPassword) {

		objPojo.getObjUtilities().logReporter("Set Password : " + strPassword,
				objPojo.getObjWrapperSeleniumFunctions().setText(loc_inp_Password, "admin@123"));
	}

	public void setUserType() {

		objPojo.getObjWrapperSeleniumFunctions().waitFor(1);
		objPojo.getObjWrapperSeleniumFunctions().dropDown(loc_inp_UserType, "Student");

	}

	public void clickRegister() {
		objPojo.getObjWrapperSeleniumFunctions().waitFor(2);
		objPojo.getObjUtilities().logReporter("Click Register Button : ",
				objPojo.getObjWrapperSeleniumFunctions().click(loc_btn_Register));
	}

}
