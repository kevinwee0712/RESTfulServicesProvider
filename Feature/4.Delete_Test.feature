Feature: Customer record delete test
 
Scenario: Successfully Delete One Customer Record
	Given There has been customer records on RestServiceProvider Server
	When Customer sends Restful request to delete one existed customer record
	Then Customer could retrieve information about one deletion successfully
	
Scenario: Successfully Delete All Customer Records
	Given There are customer records stored on RestServiceProvider Server
	When Customer sends Restful request to remove all customer records
	Then Customer could retrieve information about all deletions successfully
	