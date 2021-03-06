package com.jensen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/xml")
public class Test {

	
	
	@Path("{word}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String reverser(@PathParam("word") String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        
        return "<word>" + "<original>" + sb.toString() + "</original>" + "<reversed>" + sb.reverse().toString()
                + "</reversed>" + "</word>";
        
    }
 
}