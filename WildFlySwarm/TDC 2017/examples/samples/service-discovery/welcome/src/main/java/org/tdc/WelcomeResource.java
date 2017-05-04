package org.tdc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.wildfly.swarm.topology.Advertise;

/**
 * @author Ken Finnigan
 */
@Path("welcome")
@Advertise("welcome")
public class WelcomeResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Message welcome(@Context UriInfo uri) {
        return new Message("Welcome to TDC 2017! Brought to you from port " + uri.getBaseUri().getPort());
    }
}
