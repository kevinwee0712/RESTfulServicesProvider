package com.helper;

import static com.helper.finalPathString.RESOURCE_PATH;
import static com.helper.finalPathString.SERVER_URI;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.rest.datapool.Customer;

/** 
 * Restful Service Provider Test base Class
 * 
 * Description: All test cases could extend from this base helper class and invoke common testing method within this class.
 *                                               
 * Rest API Format : CREATE/POST    http://{host}/RESTfulServicesProvider/rest/customers 
 * 					 DELETE/DELETE  http://{host}/RESTfulServicesProvider/rest/customers[/{customerID}] 
 *                   UPDATE/PUT     http://{host}/RESTfulServicesProvider/rest/customers/{customerID} 
 *                   READ/GET       http://{host}/RESTfulServicesProvider/rest/customers/{customerID} 
 * 
 *                                 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */
public class baseHelper {
	
	private final static Boolean DEBUG = false;  //Once enable, more log info will be provided. For dev debug use only.

	private static void banner(String content) {	
		
		System.out.println("****************************************************");
		System.out.println("------- "+content);
		System.out.println("****************************************************");
		
	}
	
	/**
	 * To check whether customer record(s) could be found after CRUD a Restful Web Service
	 * 
	 * @param wsResponse  : A Rest Response after one (GET/POST/PUT/DELETE) request was sent.
	 * @param customers   : Specific customer object that should be returned.
	 * @return true :  Corresponding customer object has been found in response.
	 *         false:  Expected customer object has not been found in response.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	protected static Boolean checkCustomerExist(String wsResponse, Customer... customers) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		//Convert a JSON format string to corresponding object
		Customer[] restReturnCustomers = mapper.readValue(wsResponse, Customer[].class);
		
		if (DEBUG) {			
			banner("For Debug purpose!!");
			for (Customer customer : restReturnCustomers) {
				System.out.println(customer.toString());
			}
			for (Customer customer : customers) {
				System.out.println(customer.toString());
			}
		}
		
		//Compare whether Customer records are consistent. In order to omit th sequence, put them in a HashSet to compare.
		Set<Customer> s1 = new HashSet<Customer>(Arrays.asList(restReturnCustomers));
		Set<Customer> s2 = new HashSet<Customer>(Arrays.asList(customers));
		
		return s1.equals(s2);
	}
	

	/**
	 * To send a POST request to Web Server to create a new customer record
	 * 
	 * @param customer : Specific customer object expected to be created in Web Server 
	 */
	protected static void createCustomer(Customer customer) {
		
		banner("Customer with ID: "+customer.getCustomerID() + " will be created!");
		Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
		WebTarget target = client.target(SERVER_URI + RESOURCE_PATH);
		Response response = target.request()
				.buildPost(Entity.entity(customer, MediaType.APPLICATION_JSON))
				.invoke();
		response.close();  // Close connections
	}

	/**
	 * To send a DELETE request to Web Server to remove a customer record 
	 * 
	 * @param customer : Specific customer object expected to be removed in Web Server 
	 */
	protected static void deleteOneCustomer(Customer customer) {
		
		banner("Customer with ID: "+customer.getCustomerID()+" will be removed!");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(SERVER_URI + RESOURCE_PATH +"/"+customer.getCustomerID());
		Response response = target.request().delete();
		response.close();   // Close connections
		
	}
	
	/**
	 * To send a DELETE request to Web Server to remove all customer records
	 * 
	 */
	protected static void deleteAllCustomers() {

		banner("All customer records will be removed!");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(SERVER_URI + RESOURCE_PATH);
		Response response = target.request().delete();
		response.close(); // Close connections

	}

	/**
	 * To send a PUT request to Web Server to update one customer record
	 * 
	 * @param oldCustomerRecord : Specific customer object expected to be changed in Web Server 
	 * @param newCustomerRecord : Target customer object expected to be changed to in Web Server 
	 */
	protected static void updateCustomer(Customer oldCustomerRecord, Customer newCustomerRecord) {
		
		banner("Customer with ID: "+oldCustomerRecord.getCustomerID()+" will be updated!");
		Client client = ClientBuilder.newClient().register(
				JacksonJsonProvider.class);
		WebTarget target = client.target(SERVER_URI + RESOURCE_PATH +"/"+oldCustomerRecord.getCustomerID());
		Response response = target.request()
				.buildPut(Entity.entity(newCustomerRecord, MediaType.APPLICATION_JSON))
				.invoke();
		response.close();    // Close connections
	}

	/**
	 * To send a GET request to Web Server to read one customer record
	 * 
	 * @param testCustomer : Specific customer object expected to be read in Web Server 
	 * @return Customer    : Actual customer object returned from Web Server 
	 */
	protected static Customer readCustomerRecord(Customer testCustomer) {
		
		banner("Customer with ID: "+testCustomer.getCustomerID()+ "'s record will be read!");
		Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
		WebTarget target = client.target(SERVER_URI + RESOURCE_PATH +"/"+testCustomer.getCustomerID());
		Response response = target.request().get();
		Customer customer = response.readEntity(Customer.class);
		response.close();   // Close connections
		return customer;
	}

	/**
	 * To send a GET request to Web Server to retrieve all customer records
	 * 
	 * @return String : All the customer records would be returned as a JSON format in String
	 */
	protected static String getAllCustomers() {
		
		banner("Retrieve all customers' records for further check!");
		Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
		WebTarget target = client.target(SERVER_URI + RESOURCE_PATH);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		
		if (DEBUG) {
			System.out.println(value);
		}
		response.close(); // Close connections
		return value;
	}
	
}
