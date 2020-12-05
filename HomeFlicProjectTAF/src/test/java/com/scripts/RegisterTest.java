package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flows.RegisterFlow;
import com.generic.BaseTest;
import com.pageFactory.RegisterPage;

public class RegisterTest extends BaseTest {

	private RegisterFlow objRegisterFlow;
	

	public void initializeWebPages() {

		objRegisterFlow = new RegisterFlow(this);
			}

	@BeforeClass
	public void initializeWebEnvironmentAndTestDataSetupForRegisterNewUser() {
		this.initializeWebPages();
		this.initializeWebEnvironment("excelFiles/VMR");

	}
	@Test
	public void TCID_101_doRegister() {
		
		objRegisterFlow.doRegister();
	}
	

	@AfterClass
	public void tearDownEnvironment() {
		//this.getDriver().close();
	}

}
