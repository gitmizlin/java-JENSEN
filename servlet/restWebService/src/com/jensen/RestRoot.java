package com.jensen;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("/resources")
public class RestRoot {
	// Detta är vår root resource class som hanterar HTTP-requests för vår web service
	
	@GET
	@Consumes
	@Produces(MediaType.TEXT_PLAIN)
	public String getName() {		
		return "Hello";
	}

	
}