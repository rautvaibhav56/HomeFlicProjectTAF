package com.flows;

import java.util.Properties;

import com.generic.Pojo;
import com.pageFactory.HomePage;
import com.pageFactory.RegisterPage;

public class RegisterFlow {

	private Pojo objPojo;
	private String testData = "";
	private HomePage objHomePage;
	private RegisterPage objRegisterPage;
	private Properties objConfig;

	public RegisterFlow(Pojo pojo) {

		this.objPojo = pojo;
		objHomePage = new HomePage(objPojo);
		objRegisterPage = new RegisterPage(objPojo);

	}

	public String doRegister() {

		objHomePage.clickLinkRegister();
		objRegisterPage.verifyRegisterPageHeader();
		objRegisterPage.printTestDatabeanForRegister();
		objRegisterPage.setFirstName();
		objRegisterPage.setLastName();
		objRegisterPage.setPhone("");
		objRegisterPage.setEmail();
	//	objRegisterPage.setPhone(objConfig.getProperty("strPhone")+objPojo.getObjUtilities().getRandomNumberString(7));
		objRegisterPage.setPassword("student@123");
		objRegisterPage.setUserType();
		// objRegisterPage.clickRegister();

		return testData + "" + testData;

	}

}
