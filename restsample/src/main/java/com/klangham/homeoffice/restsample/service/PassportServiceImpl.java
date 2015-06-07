/**
 * 
 */
package com.klangham.homeoffice.restsample.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import com.klangham.homeoffice.restsample.web.model.Passport;

/**
 * @author klangham
 *
 */
@Component
public class PassportServiceImpl implements PassportService {

	private DateTimeFormatter fmt = DateTimeFormat.forPattern("d/M/yyyy");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.klangham.homeoffice.restsample.service.PassportService#addPassport
	 * (com.klangham.homeoffice.restsample.web.model.Passport)
	 */
	@Override
	public Passport addPassport(Passport passportToAdd) {
		Passport newPassport = new Passport();

		newPassport.setCustomerId(passportToAdd.getCustomerId());
		newPassport.setDateOfIssue(new LocalDate().toString(fmt));
		newPassport.setPassportNumber(passportToAdd.getPassportNumber());

		return newPassport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.klangham.homeoffice.restsample.service.PassportService#deletePassport
	 * (com.klangham.homeoffice.restsample.web.model.Passport)
	 */
	@Override
	public void deletePassport(Passport passportToDelete) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.klangham.homeoffice.restsample.service.PassportService#
	 * findPassportsByCustomer(java.lang.String)
	 */
	@Override
	public List<Passport> findPassportsByCustomer(String id) {
		ArrayList<Passport> listOfPassports = new ArrayList<Passport>();

		Passport passport1 = new Passport();
		passport1.setCustomerId(new BigInteger(id));
		passport1.setDateOfIssue(new LocalDate().minusYears(4).minusMonths(9).minusDays(3).toString(fmt));
		passport1.setPassportNumber(new BigInteger("123456"));

		Passport passport2 = new Passport();
		passport2.setCustomerId(new BigInteger(id));
		passport2.setDateOfIssue(new LocalDate().minusYears(3).minusMonths(1).minusDays(19).toString(fmt));
		passport2.setPassportNumber(new BigInteger("12342334"));

		listOfPassports.add(passport1);
		listOfPassports.add(passport2);
		return listOfPassports;
	}

}
