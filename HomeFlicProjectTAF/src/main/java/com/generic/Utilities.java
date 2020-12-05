package com.generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;

import org.testng.Assert;

public class Utilities {
	
	//Reusable Component =>  Date,Time Stamp  

	private Pojo objPojo;

	public Utilities(Pojo pojo) {
		this.objPojo = pojo;
	}

	public String getRandomString(int lenght) {
		String allowedChars = "abcdefghz";
		String randomstring = "";
		for (int i = 0; i < lenght; i++) {
			int rnum = (int) Math.floor(Math.random() * allowedChars.length());
			randomstring += allowedChars.substring(rnum, rnum + 1);
		}
		return randomstring;
	}
	
	
	// Generate random String of given length
	public String getRandomNumberString(int lenght) {
		String allowedChars = "0123456789";
		String randomstring = "";
		for (int i = 0; i < lenght; i++) {
			int rnum = (int) Math.floor(Math.random() * allowedChars.length());
			randomstring += allowedChars.substring(rnum, rnum + 1);
		}
		return randomstring;
	}
	

	public void logReporter(String step, boolean blnFlag) {

		if (blnFlag) {
			System.out.println("Step pass description : " + step);
			Assert.assertTrue(true);
		} else {
			System.out.println("Step Fail Description : " + step);
			Assert.assertTrue(false);
		}
	}

	public void logReporter(String step, String inputValue, boolean blnFlag) {

		if (blnFlag) {
			System.out.println("Step pass description  : " + step + " - " + inputValue);
			Assert.assertTrue(true);
		} else {
			System.out.println("Step Fail Description : " + step + " - " + inputValue);
			Assert.assertTrue(false);
		}
	}

	public void logReporter(String step, String expectedValue, String actualValue, boolean blnFlag) {

		if (blnFlag) {
			System.out.println("Step pass description : " + step + " Expected value is - " + expectedValue
					+ "  Actual value - " + actualValue);
			Assert.assertTrue(true);
		} else {
			System.out.println("Step pass description : " + step + " Expected value is - " + expectedValue
					+ "  Actual value - " + actualValue);
			Assert.assertTrue(false);
		}
	}

	/*
	 * @Method : getDateInSpecifiedFormat
	 * 
	 * @Description : This method takes parameter of your required DateFormat
	 * Type Like: dd-mm-YYYY DD.MM.YYYY and in return it will give you today's
	 * date in specified date format
	 * 
	 * @param : dateFormat like : dd-MM-YYYY
	 * 
	 * @author : Framework Developer
	 *
	 */
	public String getDateInSpecifiedFormat(String dateFormat) {
		String current_date = "";
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		current_date = formatter.format(today);
		// System.out.println("getDateInSpecifiedFormat "+dateFormat + " -
		// "+current_date);
		return current_date;
	}

	public String dpString(String columnHeader) {
		Hashtable<String, String> dataPoolHashTable = objPojo.getDataPoolHashTable();
		try {
			if (dataPoolHashTable.get(columnHeader) == null)
				return "";
			else {
				// System.out.println("I found, Key: "+columnHeader + " Value :
				// " + dataPoolHashTable.get(columnHeader));
				// Log.info("I found, Key: "+columnHeader + " Value : " +
				// dataPoolHashTable.get(columnHeader));
				return dataPoolHashTable.get(columnHeader);
			}
		} catch (Exception exception) {
			System.out.println("DataPool fetching issue");
			throw new RuntimeException(exception);
		}
	}

}
