package com.redhat.greetings.web;

import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyReactiveMessagingApplication.class);

    @Incoming("greetings-in")
    public void greetingsSink(Greeting greeting) {
        LOGGER.debug("Greeting incoming: {}", greeting);
    }
}
