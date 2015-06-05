/**
 * 
 */
package com.klangham.homeoffice.restsample.web.model;

import java.util.ArrayList;

/**
 * @author klangham
 *
 */
public class Customer {
	private String firstName;
	
	private String lastName;
	
	private String dateOfBirth;
	
	private String locOfBirth;
	
	private String gender;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(final String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the locOfBirth
	 */
	public String getLocOfBirth() {
		return locOfBirth;
	}

	/**
	 * @param locOfBirth the locOfBirth to set
	 */
	public void setLocOfBirth(final String locOfBirth) {
		this.locOfBirth = locOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(final String gender) {
		this.gender = gender;
	}
}
