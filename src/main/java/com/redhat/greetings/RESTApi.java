package com.redhat.greetings;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/greetings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RESTApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTApi.class);

    @Inject
    @Channel("greetings-out")
    Emitter<Greeting> kafkaAdapter;

    @POST
    public Response addGreeting(Greeting greeting) {

        LOGGER.debug("Greeting received: {}", greeting);
        kafkaAdapter.send(greeting);
        return Response.accepted().build();
    }
}
