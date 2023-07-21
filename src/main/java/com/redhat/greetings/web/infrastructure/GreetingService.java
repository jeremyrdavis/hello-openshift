package com.redhat.greetings.web.infrastructure;

import com.redhat.greetings.cqrs.api.CQRSService;
import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.web.domain.GreetingJSON;
import com.redhat.greetings.web.domain.GreetingSubmission;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GreetingService {

    static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);
    
    List<GreetingJSON> greetingJSONList;

    @Inject
    CQRSService CQRSService;

    @Inject
    @Channel("greeting-submissions")
    Emitter<GreetingDTO> greetingDTOEmitter;
    @Transactional
    public Uni<Void> processGreetingSubmission(GreetingJSON greetingJSON) {

        LOGGER.debug("processingGreetingSubmission from: {}", greetingJSON);
        GreetingSubmission greetingSubmission = GreetingSubmission.fromGreetingJSON(greetingJSON);
        greetingSubmission.persist();
        greetingDTOEmitter.send(greetingSubmission.toDTO());
        return null;
    }

    public List<GreetingJSON> allGreetings() {
        return greetingJSONList;
    }

    private List<GreetingJSON> getGreetings() {
            return CQRSService.allGreetings().stream().map(greetingDTO -> {
                return new GreetingJSON(greetingDTO.text(), greetingDTO.author());
            }).collect(Collectors.toList());
    }

    @PostConstruct
    void setUp() {
        greetingJSONList = getGreetings();
    }
}
