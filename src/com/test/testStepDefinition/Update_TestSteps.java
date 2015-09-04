package com.test.testStepDefinition;

import org.junit.Assert;

import com.helper.baseHelper;
import com.rest.datapool.Customer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Update_TestSteps extends baseHelper{
	
	 Customer customer1 = new Customer("Kevin", "Humber Place", "027-111");
	 Customer customer2 = new Customer("Andy", "New Windsor", "027-222");
	 Customer customer3 = new Customer("Walle", "Albony", "027-333");

	@Given("^There has been customer records stored on a RestServiceProvider Server$")
	public void prepareCustomerEnvBeforeHand() throws Throwable {
	   
		deleteAllCustomers();
		createCustomer(customer1);
		createCustomer(customer2);
		
	}

	@When("^Customer sends Restful request to update one existed customer record$")
	public void sendUpdateRequestToServer() throws Throwable {
	    
		updateCustomer(customer2,customer3);
		
	}

	@Then("^Customer could retrieve information about that updated customer record$")
	public void verifyCustomerRecordUpdate() throws Throwable {
	    
		Assert.assertFalse("Verify that customer2's record has been replaced? ", checkCustomerExist(getAllCustomers(), customer1, customer2));
		Assert.assertTrue("Verify that customer2's record has replaced by customer3's ?", checkCustomerExist(getAllCustomers(), customer1, customer3));
		
	}

}
