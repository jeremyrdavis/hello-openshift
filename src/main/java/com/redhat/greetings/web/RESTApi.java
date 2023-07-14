package com.redhat.greetings.web;

import com.redhat.greetings.domain.GreetingDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

@Path("/greetings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RESTApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTApi.class);

    @Inject
    GreetingRepository greetingRepository;

    @Inject
    @Channel("greetings-out")
    Emitter<GreetingDTO> greetingEmitter;

    @POST
    @Transactional
    public Response addGreeting(GreetingDTO greetingDTO) {

        LOGGER.debug("adding Greeting: {}", greetingDTO);
        greetingEmitter.send(greetingDTO);
        return Response.accepted().build();
    }

    @GET
    public Response allGreetings(){
        return Response.ok().entity(greetingRepository.listAll().stream().map(greeting -> {
            return new GreetingDTO(greeting.id, greeting.text, greeting.author, greeting.sourceSystem, greeting.createdAt);
        }).collect(Collectors.toList())).build();
    }
}
