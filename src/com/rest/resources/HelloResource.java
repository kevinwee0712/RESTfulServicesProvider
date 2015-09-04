package com.rest.resources;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.MediaType;  
  
/**
 * A GET test service to check whether basic RESTFul service is working or not  
 *   
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */

@Path("/hello")  
public class HelloResource {  
    @GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public String sayHello() {  
        return "Hello World!" ;  
    }  
   
      
    @GET  
    @Path("/{param}")    
    @Produces("text/plain;charset=UTF-8")  
    public String sayHelloToUTF8(@PathParam("param") String username) {  
        return "Hello " + username;  
    }  
      
}  