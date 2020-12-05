package com.generic;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest extends Pojo {
//Centralized Env Set Up class 

	private WebDriver webDriver;
	private String baseURL;
	
	private Properties objConfig;
	private TestDataBean objTestDataBean;
	private InitializtionAndTearDownenvironment objInitializtionAndTearDownenvironment;
	private WebDriverWait webDriverWait;
	private Utilities objUtilities;
	private WrapperSeleniumFunctions objWrapperSeleniumFunctions;
	Hashtable<String, Hashtable<String, String>> testDataTable = new Hashtable<String, Hashtable<String, String>>();
	Hashtable<String, String> testDataForTest = new Hashtable<String, String>();

	public void initializeWebEnvironment(String testDataFilePath) {

		this.loadConfigProperties();
		this.loadDataProvider(testDataFilePath);
		this.setObjConfig(objConfig);
		baseURL = objConfig.getProperty("AUT_URL");
		this.setBaseURL(baseURL);
		
		objTestDataBean = new TestDataBean();
		this.setObjTestDataBean(objTestDataBean);
		objInitializtionAndTearDownenvironment = new InitializtionAndTearDownenvironment();


		webDriver = objInitializtionAndTearDownenvironment.initializeWebDriverEnvironment(objConfig);
		this.setDriver(webDriver);
	
		webDriver.get(baseURL);

		webDriverWait = new WebDriverWait(webDriver, Integer.parseInt(objConfig.getProperty("webdriverWait")));

		this.setWebDriverwait(webDriverWait);

		objWrapperSeleniumFunctions = new WrapperSeleniumFunctions(this);
		this.setObjWrapperSeleniumFunctions(objWrapperSeleniumFunctions);

		objUtilities = new Utilities(this);
		this.setObjUtilities(objUtilities);
	}

	public void loadConfigProperties() {
		try {

			objConfig = new Properties();
			objConfig.load(new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Method : loadDataProvider
	 * @param : testCaseID - test case id
	 * @param : testDataFile - test data file
	 * @Description : Load Data from Excel for the running testCase and return as
	 *              Object array
	 * @author : Framework Developer
	 */
	public void loadDataProvider(String testDataFilePath) {
		if (!testDataFilePath.equals("")) {
			this.loadConfigProperties();
			testDataFilePath = System.getProperty("user.dir") + "/src/test/resources/testData/" + testDataFilePath
					+ ".xlsx";
			DataPool objDataPool = new DataPool();
			testDataTable = objDataPool.loadTestData(testDataFilePath);
			// System.out.println("testDataTable------>" + testDataTable);
		}
	}

	/**
	 * @Method : loadTestData
	 * @param : runID - test case run id
	 * @param : dataSet - test data hash table
	 * @Description : Load data from excel for the running testCase and return as
	 *              Object array
	 * @author : Framework Developer
	 */
	public void loadTestData(String TCIDRowNumber) {
		testDataForTest = testDataTable.get(TCIDRowNumber);
		System.out.println("testDataForTest------->" + testDataForTest);
		setDataPoolHashTable(testDataForTest);
		objUtilities = new Utilities(this);
		this.setObjUtilities(objUtilities);
		System.out.println("TCID " + TCIDRowNumber + " Startred at "
				+ objUtilities.getDateInSpecifiedFormat("dd-MMM-yyyy-HH-mm-ss"));
	}

}
