/**
 * 
 */
package com.klangham.homeoffice.restsample.web.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klangham.homeoffice.restsample.service.CustomerService;
import com.klangham.homeoffice.restsample.service.PassportService;
import com.klangham.homeoffice.restsample.web.model.Customer;
import com.klangham.homeoffice.restsample.web.model.Passport;


/**
 * @author klangham
 *
 */
@RestController()
@RequestMapping("")
public class CustomerController {

	@Autowired
	private transient CustomerService customerService;
	
	@Autowired
	private transient PassportService passportService;

	/**
	 * Adds a customer.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param dateOfBirth the date of birth
	 * @param locOfBirth the loc of birth
	 * @param gender the gender
	 * @return the customer
	 */
	@RequestMapping(value="/customer", method = RequestMethod.POST)
    public Customer addCustomer(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final String dateOfBirth, @RequestParam final String locOfBirth, @RequestParam final String gender) {
    	Customer customerToAdd = new Customer();
    	customerToAdd.setFirstName(firstName);
    	customerToAdd.setLastName(lastName);
    	customerToAdd.setDateOfBirth(dateOfBirth);
    	customerToAdd.setLocOfBirth(locOfBirth);
    	customerToAdd.setGender(gender);
    	
    	return customerService.addCustomer(customerToAdd);
    }
    
    /**
     * Find passports for a specified customer.
     *
     * @param id the id
     * @return the list< passport>
     */
    @RequestMapping(value="/customer/{id}/passport", method = RequestMethod.GET)
    public List<Passport> findPassports(@PathVariable final String id) {
    	return passportService.findPassportsByCustomer(id);
    }
    
	
    /**
     * Adds a passport for a specified customer.
     *
     * @param id the id
     * @param passportNumber the passport number
     * @return the passport
     */
    @RequestMapping(value="/customer/{id}/passport", method = RequestMethod.POST)
    public Passport addPassport(@PathVariable final String id, @RequestParam final String passportNumber) {
    	Passport passportToAdd = new Passport();
    	passportToAdd.setPassportNumber(BigInteger.valueOf(Long.valueOf(passportNumber)));
    	passportToAdd.setCustomerId(new BigInteger(id));
    	
    	return passportService.addPassport(passportToAdd);
    }
}
