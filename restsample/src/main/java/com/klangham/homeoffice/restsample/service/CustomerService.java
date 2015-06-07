/**
 * 
 */
package com.klangham.homeoffice.restsample.service;

import com.klangham.homeoffice.restsample.web.model.Customer;

/**
 * @author klangham
 *
 */
public interface CustomerService {

	/**
	 * Adds the customer.
	 *
	 * @param customerToAdd
	 *            the customer to add
	 * @return the customer
	 */
	Customer addCustomer(Customer customerToAdd);
}
