Feature: Customer record add test
 
Scenario: Successfully Add One Customer Record
	Given There is no customer record stored on RestServiceProvider Server
	When Customer sends a Restful request to add one customer record
	Then Customer could retrieve one customer information back successfully
	
Scenario: Successfully Add Another Customer Record
	Given There is one customer record stored on RestServiceProvider Server
	When Customer sends request to add another customer record
	Then Customer could retrieve two customers information back successfully