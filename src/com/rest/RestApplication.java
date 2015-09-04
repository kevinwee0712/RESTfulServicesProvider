package com.rest;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import com.rest.resources.iCustomerFactory;
import com.rest.resources.CustomerResource;
   
/**
 * Register JSON so that Customer Object could be handled in JSON format
 * 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */
public class RestApplication extends ResourceConfig {  
    public RestApplication() {  
   
     //When there is a new RESTFul service provider created, only need to change this place to point to that new implement.	
     iCustomerFactory cf = new CustomerResource();
     
     //Where the resources package resides
     packages(cf.getClass().getPackage().getName());  
     //Register JSON  
     register(JacksonJsonProvider.class);  
   
    }  
}  
