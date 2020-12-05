package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flows.ForgotPasswordFlow;
import com.flows.LoginLogoutFlow;
import com.generic.BaseTest;
import com.pageFactory.MyProfilePage;
import com.popupFactory.ForgotPasswordPage;

public class LoginTest extends BaseTest{
	
	//Test Scripts
	
	private LoginLogoutFlow objLoginLogoutFlow;
	private MyProfilePage objMyProfilePage;
	private ForgotPasswordFlow objForgotPasswordFlow;
	
	public void initializeWebPages() {
		
		objLoginLogoutFlow= new LoginLogoutFlow(this);
		objMyProfilePage =new MyProfilePage(this);
		objForgotPasswordFlow = new ForgotPasswordFlow(this);
	}

	@BeforeClass
	public void initializeWebEnvironmentAndTestDataSetup() {
		this.initializeWebPages();
		this.initializeWebEnvironment("excelFiles/VMR");
	}

	@Test(priority = 1, enabled = false)
	public void TCID_101_VerifyLogin() {
		
		this.loadTestData("TCID_101_VerifyLogin");
		objLoginLogoutFlow.doLogin();
		objMyProfilePage.verifyLogoutLinkDisplayed();
	}
	
	
	@Test(priority = 1, enabled = true)
	public void TCID_102_ForgotPassword() {
		
		this.loadTestData("TCID_102_ForgotPassword");
		objForgotPasswordFlow.clickOnForgotPasswordLink();
		
	}

	@AfterClass
	public void tearDownEnvironment() {
		this.getDriver().close();
	}

}

	
	


