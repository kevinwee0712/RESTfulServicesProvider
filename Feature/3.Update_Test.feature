Feature: Customer record update test
 
Scenario: Successfully Update One Customer Record
	Given There has been customer records stored on a RestServiceProvider Server
	When Customer sends Restful request to update one existed customer record
	Then Customer could retrieve information about that updated customer record
	