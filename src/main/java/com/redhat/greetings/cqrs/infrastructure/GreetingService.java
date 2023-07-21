package com.redhat.greetings.cqrs.infrastructure;

import com.redhat.greetings.cqrs.domain.GreetingRepository;
import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.cqrs.api.CQRSService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GreetingService implements CQRSService {

    static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    @Inject
    GreetingRepository greetingRepository;

    @Incoming("greeting-submissions")
    public void greetingsSink(GreetingDTO greetingDTO) {
        LOGGER.debug("Greeting incoming: {}", greetingDTO);
    }

    @Override
    public void addGreeting(GreetingDTO greetingDTO) {

    }

    @Override
    public List<GreetingDTO> listAllGreetings() {
        return greetingRepository.streamAll().map(greeting -> {
            LOGGER.debug("greeting: {}", greeting);
            return new GreetingDTO(greeting.getId(), greeting.getText(), greeting.getAuthor(), greeting.getSourceSystem(), greeting.getCreatedAt(), greeting.isVerifiedFamilyFriendly());
        }).collect(Collectors.toList());
    }
}
