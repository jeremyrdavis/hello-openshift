package com.redhat.greetings.web;

import com.redhat.greetings.web.domain.GreetingJSON;
import com.redhat.greetings.web.infrastructure.GreetingService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Path("/greetings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    GreetingService greetingService;

    @POST
    @Transactional
    public Response addGreeting(GreetingJSON greetingJSON) {

        LOGGER.debug("adding Greeting: {}", greetingJSON);
        greetingService.processGreetingSubmission(greetingJSON);
        return Response.accepted().build();
    }

    @GET
    public Response allGreetings(){

        return Response.ok().entity(greetingService.allGreetings()).build();
    }
}
