/**
 * 
 */
package com.klangham.homeoffice.restsample.web.controller;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.parsing.Parser;
import com.klangham.homeoffice.restsample.service.CustomerServiceImpl;
import com.klangham.homeoffice.restsample.web.model.Customer;

/**
 * @author klangham
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	@Mock
	private CustomerServiceImpl customerService;
	
	@InjectMocks
    private CustomerController customerController;
	
	/**
	 * Test method for {@link com.klangham.homeoffice.restsample.web.controller.CustomerController#addCustomer(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddCustomer() throws Exception {
		Customer newCustomer = new Customer();
		newCustomer.setFirstName("John");
		newCustomer.setLastName("Doe");
		newCustomer.setDateOfBirth("26041993");
		newCustomer.setLocOfBirth("here");
		newCustomer.setGender("M");
		when(customerService.addCustomer(any(Customer.class))).thenReturn(newCustomer);
		
		given().
			standaloneSetup(customerController).
			params("firstName", "John", "lastName", "Doe", "dateOfBirth", "26041993", "locOfBirth", "here", "gender", "M").
		when().
			post("/customer").
		then().
			using().parser("application/json;charset=UTF-8", Parser.JSON).
			body("firstName", equalTo("John"), "lastName", equalTo("Doe"), "dateOfBirth", equalTo("26041993"), "locOfBirth", equalTo("here"), "gender", equalTo("M"));
	}
}
