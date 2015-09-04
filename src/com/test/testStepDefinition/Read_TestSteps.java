package com.test.testStepDefinition;

import org.junit.Assert;

import com.helper.baseHelper;
import com.rest.datapool.Customer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Read_TestSteps extends baseHelper{

	private Customer customer1 = new Customer("Kevin", "Humber Place", "027-111");
	private Customer customer2 = new Customer("Andy", "New Windsor", "027-222");
	private Customer testCustomer =null;
	
	@Given("^There has been customer records stored on RestServiceProvider Server$")
	public void setUpCustomerEnvBeforeHand() throws Throwable {
		
		deleteAllCustomers();
		createCustomer(customer1);
		createCustomer(customer2);
		
	}

	@When("^Customer sends Restful request to read one existed customer record$")
	public void sendReadRequestToServer() throws Throwable {
		
		testCustomer = readCustomerRecord(customer2);
		
	}

	@Then("^Customer could retrieve information about that specific customer record$")
	public void verifyCustomerRecordRead() throws Throwable {
		
		Assert.assertTrue("Verify that correct customer record has been returned? ", testCustomer.equals(customer2));
		
	}
	
}
