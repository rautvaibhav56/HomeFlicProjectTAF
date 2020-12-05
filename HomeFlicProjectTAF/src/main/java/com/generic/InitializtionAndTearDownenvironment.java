package com.generic;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitializtionAndTearDownenvironment {
//Initialize webEnv , open , close browser. 
	
	private WebDriver driver;

	public WebDriver initializeWebDriverEnvironment(Properties objConfig) {

		String strBrowser = objConfig.getProperty("web_Browser");

		if (strBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (strBrowser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (strBrowser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

}
