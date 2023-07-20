package com.redhat.greetings.cqrs.api.infrastructure;

import com.redhat.greetings.domain.GreetingDTO;
import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyReactiveMessagingApplication.class);

    @Incoming("greetings-in")
    public void greetingsSink(GreetingDTO greetingDTO) {

        LOGGER.debug("Greeting incoming: {}", greetingDTO);
    }
}
