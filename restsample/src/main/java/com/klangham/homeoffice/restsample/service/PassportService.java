/**
 * 
 */
package com.klangham.homeoffice.restsample.service;

import java.util.List;

import com.klangham.homeoffice.restsample.web.model.Passport;

/**
 * @author klangham
 *
 */
public interface PassportService {

	/**
	 * Adds a passport.
	 *
	 * @param passportToAdd
	 *            the passport to add
	 * @return the passport
	 */
	Passport addPassport(Passport passportToAdd);

	/**
	 * Deletes a passport.
	 *
	 * @param passportToDelete
	 *            the passport to delete
	 */
	void deletePassport(Passport passportToDelete);

	/**
	 * Find passports by customer.
	 *
	 * @param id
	 *            the id
	 * @return the list
	 */
	List<Passport> findPassportsByCustomer(String id);

}
