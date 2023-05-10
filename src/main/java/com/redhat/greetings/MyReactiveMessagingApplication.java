package com.redhat.greetings;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyReactiveMessagingApplication.class);

    @Incoming("greetings-in")
    public void greetingsSink(Greeting greeting) {
        LOGGER.debug("Greeting incoming: {}", greeting);
    }
}
