/**
 * 
 */
package com.klangham.homeoffice.restsample.web.model;

import java.math.BigInteger;

/**
 * @author klangham
 *
 */
public class Passport {
	
	private BigInteger passportId;

	private BigInteger customerId;
	
	private BigInteger passportNumber;
	
	private String dateOfIssue;

	/**
	 * @return the passportId
	 */
	public BigInteger getPassportId() {
		return passportId;
	}

	/**
	 * @param passportId the passportId to set
	 */
	public void setPassportId(BigInteger passportId) {
		this.passportId = passportId;
	}

	/**
	 * @return the customerId
	 */
	public BigInteger getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the passportNumber
	 */
	public BigInteger getPassportNumber() {
		return passportNumber;
	}

	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(BigInteger passportNumber) {
		this.passportNumber = passportNumber;
	}

	/**
	 * @return the dateOfIssue
	 */
	public String getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
}
