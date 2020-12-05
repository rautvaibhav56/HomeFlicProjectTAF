package com.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class WrapperSeleniumFunctions extends LoadableComponent<WrapperSeleniumFunctions> {

	// Click,setText,Radio,chek Box,Window Handle.

	private Pojo objPojo;

	public WrapperSeleniumFunctions(Pojo pojo) {

		this.objPojo = pojo;
	}

	public void waitForElementPresence(By locator) throws NotFoundException {
		objPojo.getWebDriverwait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementVisibilityLocated(By locator) throws NotFoundException {

		objPojo.getWebDriverwait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public boolean checkElementDisplayed(By locator) {

		try {
			this.waitForElementVisibilityLocated(locator);
			objPojo.getDriver().findElement(locator).isDisplayed();
			return true;
		} catch (Exception e) {
			System.out.println("Error message ");
			e.printStackTrace();
			return false;
		}
	}

	public boolean click(By locator) {

		try {

			this.waitForElementPresence(locator);
			objPojo.getDriver().findElement(locator).click();
			WebElement element = objPojo.getDriver().findElement(locator);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean setText(By locator, String fieldValue) {
		try {

			this.waitForElementPresence(locator);
			this.waitForElementVisibilityLocated(locator);
			WebElement element = objPojo.getDriver().findElement(locator);
			element.clear();
			element.sendKeys(fieldValue);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean dropDown(By locator, String fieldValue) {

		try {

			this.waitForElementPresence(locator);
			objPojo.getDriver().findElement(locator);
			this.waitForElementVisibilityLocated(locator);
			WebElement element = objPojo.getDriver().findElement(locator);
			Select sel = new Select(element);
			sel.selectByVisibleText(fieldValue);

			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

}