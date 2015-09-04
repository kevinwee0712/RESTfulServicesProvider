package com.test.testStepDefinition;

import org.junit.Assert;

import com.helper.baseHelper;
import com.rest.datapool.Customer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Delete_TestSteps extends baseHelper{

	 Customer customer1 = new Customer("Kevin", "Humber Place", "027-111");
	 Customer customer2 = new Customer("Andy", "New Windsor", "027-222");
	 Customer customer3 = new Customer("Walle", "Albony", "027-333");
	
	@Given("^There has been customer records on RestServiceProvider Server$")
	public void prepareCustomersOnServer()
			throws Throwable {
		
		deleteAllCustomers();
		createCustomer(customer1);
		createCustomer(customer2);
		createCustomer(customer3);
		
	}

	@When("^Customer sends Restful request to delete one existed customer record$")
	public void removeOneCustomerRecord()
			throws Throwable {
		
		deleteOneCustomer(customer3);

	}

	@Then("^Customer could retrieve information about one deletion successfully$")
	public void verifyOneCustomerRemoved()
			throws Throwable {
		
		Assert.assertFalse("Verify that customer3's record has been removed? ", checkCustomerExist(getAllCustomers(), customer1, customer2, customer3));
		Assert.assertTrue("Verify that customer1 and customer2's records are still there? ", checkCustomerExist(getAllCustomers(), customer1, customer2));
		
	}

	@Given("^There are customer records stored on RestServiceProvider Server$")
	public void prepCustomerRecordsBeforeHand()
			throws Throwable {
		
		deleteAllCustomers();
		createCustomer(customer1);
		createCustomer(customer2);
		createCustomer(customer3);
	}

	@When("^Customer sends Restful request to remove all customer records$")
	public void removeAllCustomerRecords()
			throws Throwable {
		
		deleteAllCustomers();
	}

	@Then("^Customer could retrieve information about all deletions successfully$")
	public void verifyAllCustomerRecordsRemoved()
			throws Throwable {

		Assert.assertFalse("Verify that customer1's record has been removed? ", checkCustomerExist(getAllCustomers(), customer1));
		Assert.assertFalse("Verify that customer2's record has been removed? ", checkCustomerExist(getAllCustomers(), customer2));
		Assert.assertFalse("Verify that customer3's record has been removed? ", checkCustomerExist(getAllCustomers(), customer3));
		
	}

}
