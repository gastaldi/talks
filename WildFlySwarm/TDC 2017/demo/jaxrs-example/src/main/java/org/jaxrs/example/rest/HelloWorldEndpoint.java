package org.jaxrs.example.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/helloWorld")
public class HelloWorldEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld(@Context UriInfo uriInfo) { 
        return "Hello World "+uriInfo.getBaseUri().getPort();
    }
}