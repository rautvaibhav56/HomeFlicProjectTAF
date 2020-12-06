package com.pageFactory;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class MyProfilePage {

	private Pojo objPojo;

	public MyProfilePage(Pojo pojo) {

		this.objPojo = pojo;

	}

	By loc_lnk_Logout = By.xpath("//div[@class='account-login']/ul/li/a[text()='Logout'][1]");

	public void verifyLogoutLinkDisplayed() {

		objPojo.getObjWrapperSeleniumFunctions().waitFor(1);
		objPojo.getObjUtilities().logReporter("Verify 'Logout' link is displayed on My profile Page ",
				objPojo.getObjWrapperSeleniumFunctions().checkElementDisplayed(loc_lnk_Logout));

	}

}
