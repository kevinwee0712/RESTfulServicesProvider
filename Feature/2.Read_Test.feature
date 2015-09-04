Feature: Customer record read test
 
Scenario: Successfully Read One Customer Record
	Given There has been customer records stored on RestServiceProvider Server
	When Customer sends Restful request to read one existed customer record
	Then Customer could retrieve information about that specific customer record
	