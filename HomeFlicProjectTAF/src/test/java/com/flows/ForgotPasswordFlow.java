package com.flows;

import com.generic.Pojo;
import com.pageFactory.HomePage;
import com.pageFactory.LoginPage;
import com.popupFactory.ForgotPasswordPage;

public class ForgotPasswordFlow {

	private Pojo objPojo;
	private String testData = "";
	private HomePage objHomePage;
	private LoginPage objLoginPage;
	private ForgotPasswordPage objForgotPasswordPage;

	public ForgotPasswordFlow(Pojo pojo) {
		this.objPojo = pojo;
		objHomePage = new HomePage(objPojo);
		objLoginPage = new LoginPage(objPojo);
		objForgotPasswordPage = new ForgotPasswordPage(objPojo);

	}

	public void clickOnForgotPasswordLink() {

		objHomePage.clickLinkLogin();
		objLoginPage.verifyLoginPageHeader();
		objLoginPage.clickOnForgotPassword();
		objForgotPasswordPage.verifyForgotPasswordHeader();

		testData = objPojo.getObjUtilities().dpString("strEmail");
		if (!testData.equals(""))
			objForgotPasswordPage.setUSerID(testData);
		objForgotPasswordPage.clickOnSubmitBtn();

	}

}
