/**
 * 
 */
package com.blackfez.fezcore.entities;



/**
 * @author nhans
 *
 */
public class Person {
	
	private String SurName;
	private String GivenName;
	private String MiddleName;
	private InternetAddress Email;
	
	public Person() {}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return SurName;
	}

	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		SurName = surName;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return GivenName;
	}

	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		GivenName = givenName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return MiddleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	
	

}
