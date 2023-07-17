package com.redhat.greetings.repository.api.infrastructure;

import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.repository.api.GreetingRepositoryAPI;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@ApplicationScoped
public class GreetingService implements GreetingRepositoryAPI {

    static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    @Incoming("greeting-submissions")
    public void greetingsSink(GreetingDTO greetingDTO) {
        LOGGER.debug("Greeting incoming: {}", greetingDTO);
    }

    @Override
    public void addGreeting(GreetingDTO greetingDTO) {

    }

    @Override
    public List<GreetingDTO> allGreetings() {
        return null;
    }
}
