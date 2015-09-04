package com.rest.resources;

import java.util.List;

import com.rest.datapool.Customer;


/**
 * Abstract this interface according to user requirement to offer CRUD services through
 * RESTFul Web Service. Real service provider could implement this interface to offer
 * services and once a new service provider was developed, developer only needs to change
 * one configuration in {@see RestApplication.java}
 * 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */
public interface iCustomerFactory {

	/**
	 * Create a customer record
	 * 
	 * @param customer : Specific customer object expected to be created in Web Server 
	 */
	public abstract void createCustomer(Customer customer);

	/**
	 * Delete one specific customer record
	 * 
	 * @param id :  Specific customer id expected to be removed in Web Server
	 */
	public abstract void deleteSingleCustomer(String id);

	/**
	 * Delete all customer records
	 */
	public abstract void deleteAllCustomers();

	/**
	 * Update one customer's record
	 * 
	 * @param id  : Specific customer id expected to be changed in Web Server 
	 * @param customer  : Target customer object info expected to be changed to in Web Server 
	 */
	public abstract void updateCustomer(String id, Customer customer);

	/**
	 *  Read one customer's record
	 * 
	 * @param id  : Specific customer id expected to be read from Web Server 
	 * @return customer : Actual customer object returned by Web Server 
	 */
	public abstract Customer getCustomerByName(String id);

	/**
	 * Return all customer records
	 * 
	 * @return List<Customer> : All the customer records would be returned
	 */
	public abstract List<Customer> getAllCustomers();

}