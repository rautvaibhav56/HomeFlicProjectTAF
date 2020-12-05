package com.generic;

import java.util.Locale;

import com.github.javafaker.Faker;

//Load Random fake data using Java Faker
public class TestDataBean {

	private Faker objFaker;
	private Locale objLocale;
	private String strFullName;
	private String strFirstName;
	private String strLastName;
	private String strPhone;
	private String strAddress;
	
	
	
	public TestDataBean() {
		objLocale = new Locale("en-IND");
		objFaker = new Faker(objLocale);
	}
	public String getStrPhone() {
		strPhone = objFaker.phoneNumber().cellPhone();
		return strPhone;
	}

	public Faker getObjFaker() {
		return objFaker;
	}

	public String getStrFullName() {
		strFullName = objFaker.name().fullName();
		return strFullName;
	}

	public String getStrFirstName() {
		strFirstName = objFaker.name().firstName();
		return strFirstName;
	}

	public String getStrLastName() {
		strLastName = objFaker.name().lastName();
		return strLastName;
	}

	public String getStrAddress() {
		strAddress = objFaker.address().city();
		return strAddress;
	}

}
