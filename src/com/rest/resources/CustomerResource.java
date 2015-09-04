package com.rest.resources;

import static com.helper.finalPathString.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.datapool.Customer;

/**
 * Real Restful Service Provider which would be run on Server Side to provide Restful services to customer
 * 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */

@Path(RESOURCE_PATH)
public class CustomerResource implements iCustomerFactory {
	
	//Act as a database to store customer records 
	private static Map<String, Customer> customerMap = new HashMap<String, Customer>();
 
	@Override
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void createCustomer(Customer customer) {
		customerMap.put(customer.getCustomerID(), customer);  //Response to a POST request and then store one customer record 
	}

	@Override
	@DELETE
	@Path("{"+ ID_PATH + "}")
	public void deleteSingleCustomer(@PathParam(ID_PATH) String id) {
		customerMap.remove(id);  //Response to a DELETE request and then remove one customer record 
	}

	@Override
	@DELETE
	public void deleteAllCustomers() {
		customerMap.clear();   //Response to a DELETE request and then remove all customer records
	}

	@Override
	@PUT
	@Path("{"+ID_PATH+"}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCustomer(@PathParam(ID_PATH) String id, Customer customer) {
		customerMap.remove(id);   //Response to a PUT request and then update one customer record
		customerMap.put(customer.getCustomerID(), customer); 
	}

	@Override
	@GET
	@Path("{"+ ID_PATH +"}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer getCustomerByName(@PathParam(ID_PATH) String id) {
		Customer c = customerMap.get(id);  //Response to a GET request and then return one customer record
		return c;
	}

	@Override
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers.addAll(customerMap.values());  //Response to a GET request and then return all customer records
		return customers;
	}

}
