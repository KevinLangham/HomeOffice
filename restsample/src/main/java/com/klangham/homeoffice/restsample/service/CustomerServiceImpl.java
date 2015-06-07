/**
 * 
 */
package com.klangham.homeoffice.restsample.service;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import com.klangham.homeoffice.restsample.web.model.Customer;

/**
 * @author klangham
 * 
 */
@Component
public class CustomerServiceImpl implements CustomerService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.klangham.homeoffice.restsample.service.CustomerService#addCustomer
	 * (com.klangham.homeoffice.restsample.web.model.Customer)
	 */
	@Override
	public Customer addCustomer(Customer customerToAdd) {
		Customer newCustomer = new Customer();

		newCustomer.setCustomerId(new BigInteger("1234"));
		newCustomer.setFirstName(customerToAdd.getFirstName());
		newCustomer.setLastName(customerToAdd.getLastName());
		newCustomer.setDateOfBirth(customerToAdd.getDateOfBirth());
		newCustomer.setLocOfBirth(customerToAdd.getLocOfBirth());
		newCustomer.setGender(customerToAdd.getGender());

		return newCustomer;
	}

}
