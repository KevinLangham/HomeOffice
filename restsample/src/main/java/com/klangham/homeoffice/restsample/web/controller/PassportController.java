/**
 * 
 */
package com.klangham.homeoffice.restsample.web.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klangham.homeoffice.restsample.service.PassportService;
import com.klangham.homeoffice.restsample.web.model.Passport;

/**
 * @author klangham
 *
 */
@RestController()
@RequestMapping("")
public class PassportController {

	@Autowired
	private transient PassportService passportService;

	@RequestMapping(value = "/passport", method = RequestMethod.DELETE)
	public void deletePassport(@RequestParam final String passportNumber) {
		Passport passportToDelete = new Passport();
		passportToDelete.setPassportNumber(BigInteger.valueOf(Long
				.valueOf(passportNumber)));

		passportService.deletePassport(passportToDelete);
	}
}
