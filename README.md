# HomeOffice
Home Office REST sample


Contains 4 webservices

1. Add a Customer
	Sample url : http://<server name>:<port>/klangham/customer?firstName='Keith'&lastName='Smith'&dateOfBirth='29/04/1978'&locOfBirth='here'&gender='M'
	HTTP Request type : POST
	Response : a JSON object containing the details of the saved Customer object	

2. Add a Passport
	Sample url : http://<server name>:<port>/klangham/customer/1/passport?passportNumber=6
	HTTP Request type : POST
	Response : a JSON object containing the details of the saved Passport object	

3. Find all Passports for a Customer
	Sample url : http://<server name>:<port>/klangham/customer/<customer id>/passport
	HTTP Request type : GET
	Response : a JSON array containing the details of the Passports for the specified Customer object

4. Delete a Passport
	Sample url : http://<server name>:<port>/klangham/passport?passportNumber=6
	HTTP Request type : DELETE
	Response : a 200 return code only

These can be tested in several ways:
	1. Using the REST Client Firefox plugin - https://addons.mozilla.org/en-US/firefox/addon/restclient/
	2. Using curl
		For example, to test the Find all Passports for a Customer call when running locally use
			curl -X GET -H "Accept: application/json;charset=UTF-8" http://localhost:8080/klangham/customer/1/passport
	3. Running the unit tests
