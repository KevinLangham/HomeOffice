/**
 * 
 */
package com.klangham.homeoffice.restsample.web.controller;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.parsing.Parser;
import com.klangham.homeoffice.restsample.service.CustomerServiceImpl;
import com.klangham.homeoffice.restsample.service.PassportServiceImpl;
import com.klangham.homeoffice.restsample.web.model.Customer;
import com.klangham.homeoffice.restsample.web.model.Passport;

/**
 * @author klangham
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	private static final String FIRST_NAME = "John";
	private static final String LAST_NAME = "Doe";
	private static final String DATE_OF_BIRTH = "26/04/1993";
	private static final String LOC_OF_BIRTH = "here";
	private static final String GENDER = "M";
	private static final BigInteger CUSTOMER_ID_1 = new BigInteger("1234");
	private static final String DATE_OF_ISSUE_1 = "06/03/2010";
	private static final String DATE_OF_ISSUE_2 = "06/03/2012";
	private static final BigInteger PASSPORT_NUMBER_1 = new BigInteger("9876");
	private static final BigInteger PASSPORT_NUMBER_2 = new BigInteger("8765");

	@Mock
	private CustomerServiceImpl customerService;

	@Mock
	private PassportServiceImpl passportService;

	@InjectMocks
	private CustomerController customerController;

	/**
	 * Test method for
	 * {@link com.klangham.homeoffice.restsample.web.controller.CustomerController#addCustomer(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAddCustomer() throws Exception {
		Customer newCustomer = new Customer();
		newCustomer.setFirstName(FIRST_NAME);
		newCustomer.setLastName(LAST_NAME);
		newCustomer.setDateOfBirth(DATE_OF_BIRTH);
		newCustomer.setLocOfBirth(LOC_OF_BIRTH);
		newCustomer.setGender(GENDER);
		when(customerService.addCustomer(any(Customer.class))).thenReturn(newCustomer);

		given().standaloneSetup(customerController)
				.params("firstName", FIRST_NAME, "lastName", LAST_NAME, "dateOfBirth", DATE_OF_BIRTH, "locOfBirth",
						LOC_OF_BIRTH, "gender", GENDER)
				.when()
				.post("/customer")
				.then()
				.using()
				.parser("application/json;charset=UTF-8", Parser.JSON)
				.body("firstName", equalTo(FIRST_NAME), "lastName", equalTo(LAST_NAME), "dateOfBirth",
						equalTo(DATE_OF_BIRTH), "locOfBirth", equalTo(LOC_OF_BIRTH), "gender", equalTo(GENDER));
	}

	/**
	 * Test method for
	 * {@link com.klangham.homeoffice.restsample.web.controller.CustomerController#findPassports(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindPassports() {
		List<Passport> listOfPassports = new ArrayList<Passport>();
		Passport passport1 = new Passport();
		Passport passport2 = new Passport();
		passport1.setCustomerId(CUSTOMER_ID_1);
		passport1.setDateOfIssue(DATE_OF_ISSUE_1);
		passport1.setPassportNumber(PASSPORT_NUMBER_1);

		passport2.setCustomerId(CUSTOMER_ID_1);
		passport2.setDateOfIssue(DATE_OF_ISSUE_2);
		passport2.setPassportNumber(PASSPORT_NUMBER_2);

		listOfPassports.add(passport1);
		listOfPassports.add(passport2);
		when(passportService.findPassportsByCustomer(anyString())).thenReturn(listOfPassports);

		given().standaloneSetup(customerController)
				.when()
				.get("/customer/1/passport")
				.then()
				.using()
				.parser("application/json;charset=UTF-8", Parser.JSON)
				.body("[0].customerId", equalTo(CUSTOMER_ID_1.intValue()), "[0].passportNumber",
						equalTo(PASSPORT_NUMBER_1.intValue()), "[0].dateOfIssue", equalTo(DATE_OF_ISSUE_1))
				.body("[1].customerId", equalTo(CUSTOMER_ID_1.intValue()), "[1].passportNumber",
						equalTo(PASSPORT_NUMBER_2.intValue()), "[1].dateOfIssue", equalTo(DATE_OF_ISSUE_2));
	}

	/**
	 * Test method for
	 * {@link com.klangham.homeoffice.restsample.web.controller.CustomerController#addPassport(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAddPassport() {
		Passport passport1 = new Passport();
		passport1.setCustomerId(CUSTOMER_ID_1);
		passport1.setDateOfIssue(DATE_OF_ISSUE_1);
		passport1.setPassportNumber(PASSPORT_NUMBER_1);
		when(passportService.addPassport(any(Passport.class))).thenReturn(passport1);

		given().standaloneSetup(customerController)
				.params("passportNumber", PASSPORT_NUMBER_1)
				.when()
				.post("/customer/3/passport")
				.then()
				.using()
				.parser("application/json;charset=UTF-8", Parser.JSON)
				.body("customerId", equalTo(CUSTOMER_ID_1.intValue()), "passportNumber",
						equalTo(PASSPORT_NUMBER_1.intValue()), "dateOfIssue", equalTo(DATE_OF_ISSUE_1));
	}
}
