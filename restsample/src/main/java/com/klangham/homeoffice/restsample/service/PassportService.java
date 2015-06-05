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

	Passport addPassport(Passport passportToAdd);

	void deletePassport(Passport passportToDelete);

	List<Passport> findPassportsByCustomer(String id);

}
