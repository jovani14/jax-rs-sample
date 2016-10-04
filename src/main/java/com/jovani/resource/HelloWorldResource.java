package com.jovani.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

/**
 * Root resource (exposed at "/api/1.0/hello" path)
 */
@Component
@Api( value="1.0_hello", description="HelloWorld resource")
@Path("1.0/hello")
public class HelloWorldResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value="Returns 'Hello World!!' string", notes="No comment")
	public String helloMessage() {
		return "Hello World Jersey Way!";
	}
}
