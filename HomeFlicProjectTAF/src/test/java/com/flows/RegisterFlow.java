package com.flows;

import java.util.Properties;

import com.generic.BaseTest;
import com.generic.Pojo;
import com.pageFactory.HomePage;
import com.pageFactory.RegisterPage;

public class RegisterFlow extends BaseTest {

	private Pojo objPojo;
	private String testData = "";
	private HomePage objHomePage;
	private RegisterPage objRegisterPage;
	private Properties objConfig;

	public RegisterFlow(Pojo pojo) {

		this.objPojo = pojo;
		objHomePage = new HomePage(objPojo);
		objRegisterPage = new RegisterPage(objPojo);
		objConfig = new Properties();
	}

	public String doRegister() {

		objHomePage.clickLinkRegister();
		objRegisterPage.verifyRegisterPageHeader();
		objRegisterPage.printTestDatabeanForRegister();
		objRegisterPage.setFirstName();
		objRegisterPage.setLastName();
		objRegisterPage.setPhone("");
		// objRegisterPage.setPhone(objConfig.getProperty("strPhone")+objPojo.getObjUtilities().getRandomNumberString(7));
		objRegisterPage.setEmail();
		objRegisterPage.setPassword("student@123");
		objRegisterPage.setUserType();
		// objRegisterPage.clickRegister();

		return testData + "" + testData;

	}

}
