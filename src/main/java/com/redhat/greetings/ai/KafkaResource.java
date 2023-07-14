package com.redhat.greetings.ai;

import com.redhat.greetings.web.Greeting;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaResource {

    static final Logger LOGGER = LoggerFactory.getLogger(KafkaResource.class);

    @Inject
    AIService aiService;

    @Incoming("greetings-out")
    public void onGreeting(Greeting greeting) {

        LOGGER.debug("Greeting received: {}", greeting);
        boolean isValidGreeting = aiService.validate(greeting);
    }
}
