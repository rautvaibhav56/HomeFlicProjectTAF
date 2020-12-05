package com.pageFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class HomePage {
	// Moduler Centralized Pages

	private Pojo objPojo;

	By loc_Link_Homeflic_Login = By.xpath("//a[text()='Register']/preceding::li[1]/a[text()='Login']");
	By loc_Link_Homeflic_Register = By.xpath("//a[text()='Login']/following::li[1]/a[text()='Register']");

	public HomePage(Pojo pojo) {

		this.objPojo = pojo;
	}

	public void clickLinkLogin() {
		objPojo.getObjUtilities().logReporter("Click Login Link on Homeflic Home Page ",
				objPojo.getObjWrapperSeleniumFunctions().click(loc_Link_Homeflic_Login));
	}

	public void clickLinkRegister() {
		objPojo.getObjUtilities().logReporter("Click Register Link on Homeflic Home Page ",
				objPojo.getObjWrapperSeleniumFunctions().click(loc_Link_Homeflic_Register));
	}

}
