package com.redhat.greetings.ai;

import com.redhat.greetings.ai.api.AIAPI;
import com.redhat.greetings.domain.GreetingDTO;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaResource {

    static final Logger LOGGER = LoggerFactory.getLogger(KafkaResource.class);

    @Inject
    AIAPI aiapi;

    @Incoming("greetings-verify")
    @Outgoing("greetings-verified")
    public Uni<GreetingDTO> onGreeting(final GreetingDTO greetingDTOToVerify) {

        LOGGER.debug("Greeting received: {}", greetingDTOToVerify);
        boolean isValidGreeting = aiapi.isFamilyFriendly(greetingDTOToVerify);
        return Uni.createFrom().item(new GreetingDTO(
                greetingDTOToVerify.text(),
                greetingDTOToVerify.author(),
                greetingDTOToVerify.sourceSystem(),
                greetingDTOToVerify.isVerifiedFamilyFriendly()
        ));
    }
}
