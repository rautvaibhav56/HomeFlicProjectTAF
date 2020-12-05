package com.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.generic.TestDataBean;
import com.pageFactory.DummyPage;

public class DummyTest extends BaseTest {

	private DummyPage objDummyPage;

	public void initializeWebPages() {
		objDummyPage = new DummyPage(this);
	}

	@BeforeClass
	public void initializeWebEnvironmentAndTestDataSetup() {
		this.initializeWebPages();
		this.initializeWebEnvironment("excelFiles/VMR");
	}

	@Test(priority = 1, enabled = true)
	public void test() {
		
		objDummyPage.clickLinkLogin();
		objDummyPage.setUSerID("Verve");
		objDummyPage.setPassword("Square");
		objDummyPage.clickLogin();
	}

	/*@Test(priority = 2)
	public void TCID_002_VerifyLogin() {

		this.loadTestData("TCID_002_VerifyLogin");

		String testData = this.getObjUtilities().dpString("UserName");
		System.out.println("Excel Data ===> " + testData);

		String testData1 = this.getObjUtilities().dpString("Password");
		System.out.println("Excel Data ===> " + testData1);

		String testData2 = this.getObjUtilities().dpString("Age");
		System.out.println("Excel Data ===> " + testData2);

	}

	@Test(priority = 3)
	public void TCID_001_VerifyUserLoggedIn() {

		this.loadTestData("TCID_001_VerifyUserLoggedIn");

		String testData = this.getObjUtilities().dpString("City");
		System.out.println("Excel Data ===> " + testData);
		
		
	}*/

	@AfterClass
	public void tearDownEnvironment() {
	//	this.getDriver().close();
	}

}
