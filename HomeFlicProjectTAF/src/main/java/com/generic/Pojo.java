package com.generic;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//pojo is a central class ,getters and setters methods.{Web Driver , Config , Wait , Utility , WSF }

public class Pojo {

	private WebDriver driver;
	private Properties objConfig;
	private WebDriverWait webDriverwait;
	private String baseURL;
	private TestDataBean objTestDataBean;
	private Utilities objUtilities;
	private WrapperSeleniumFunctions objWrapperSeleniumFunctions;
	private Hashtable<String, String> dataPoolHashTable;

	public Hashtable<String, String> getDataPoolHashTable() {
		return dataPoolHashTable;
	}

	public void setDataPoolHashTable(Hashtable<String, String> dataPoolHashTable) {
		this.dataPoolHashTable = dataPoolHashTable;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Properties getObjConfig() {
		return objConfig;
	}

	public void setObjConfig(Properties objConfig) {
		this.objConfig = objConfig;
	}

	public WebDriverWait getWebDriverwait() {
		return webDriverwait;
	}

	public void setWebDriverwait(WebDriverWait webDriverwait) {
		this.webDriverwait = webDriverwait;
	}

	public TestDataBean getObjTestDataBean() {
		return objTestDataBean;
	}

	public void setObjTestDataBean(TestDataBean objTestDataBean) {
		this.objTestDataBean = objTestDataBean;
	}

	public Utilities getObjUtilities() {
		return objUtilities;
	}

	public void setObjUtilities(Utilities objUtilities) {
		this.objUtilities = objUtilities;
	}

	public WrapperSeleniumFunctions getObjWrapperSeleniumFunctions() {
		return objWrapperSeleniumFunctions;
	}

	public void setObjWrapperSeleniumFunctions(WrapperSeleniumFunctions objWrapperSeleniumFunctions) {
		this.objWrapperSeleniumFunctions = objWrapperSeleniumFunctions;
	}

}
