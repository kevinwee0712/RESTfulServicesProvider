package com.test.testStepDefinition;

import org.junit.Assert;

import com.helper.baseHelper;
import com.rest.datapool.Customer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Add_TestSteps extends baseHelper{
	
	private Customer customer1 = new Customer("Kevin", "Humber Place", "027-111");
	private Customer customer2 = new Customer("Andy", "New Windsor", "027-222");

	@Given("^There is no customer record stored on RestServiceProvider Server$")
	public void removeAllCustomerRecords() throws Throwable {
		
		deleteAllCustomers();
	
	}

	@When("^Customer sends a Restful request to add one customer record$")
	public void addOneCustomerRecord() throws Throwable {
		
		createCustomer(customer1);
		
	}

	@Then("^Customer could retrieve one customer information back successfully$")
	public void verifyOneCustomerRecord() throws Throwable {

		Assert.assertTrue("Verify that "+customer1.getCustomerName()+" has been created?", 
				checkCustomerExist(getAllCustomers(), customer1));
	
	}

	@Given("^There is one customer record stored on RestServiceProvider Server$")
	public void checkCustomerRecordPremise() throws Throwable {
		
		deleteAllCustomers();
		createCustomer(customer1);
		
	}

	@When("^Customer sends request to add another customer record$")
	public void addOneMoreCustomerRecord() throws Throwable {
		
		createCustomer(customer2);
		
	}

	@Then("^Customer could retrieve two customers information back successfully$")
	public void verifyOneMoreCustomerRecord() throws Throwable {

		Assert.assertTrue("Verify that "+customer2.getCustomerName()+" has also been added?", 
				checkCustomerExist(getAllCustomers(), customer1, customer2));
	}
	
}
