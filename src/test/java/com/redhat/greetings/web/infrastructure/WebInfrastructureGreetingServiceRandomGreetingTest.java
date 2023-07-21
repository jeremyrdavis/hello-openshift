package com.redhat.greetings.web.infrastructure;

import com.redhat.greetings.cqrs.api.CQRSService;
import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.domain.SourceSystem;
import com.redhat.greetings.web.domain.GreetingJSON;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@TestProfile(WebTestProfile.class)
public class WebInfrastructureGreetingServiceRandomGreetingTest {

    static final Logger LOGGER = LoggerFactory.getLogger(WebInfrastructureGreetingServiceRandomGreetingTest.class);

    @Inject
    GreetingService greetingService;

    @InjectMock
    CQRSService cqrsServiceMock;

    @BeforeEach
    void setUp() {
        Mockito.when(cqrsServiceMock.listAllGreetings()).thenReturn(
                Arrays.asList(
                        new GreetingDTO(1L, "Ace of Spades", "Lemmy Kilminster", SourceSystem.REST_API, Instant.now(), true),
                        new GreetingDTO(2L ,"Number of the Beast", "Bruce Dickinson", SourceSystem.REST_API, Instant.now(), true)));
        LOGGER.debug(greetingService.toString());
    }

    @Test
    public void testRandomGreeting() {
        GreetingJSON greetingJSON = greetingService.randomGreeting();
        assertNotNull(greetingJSON);
    }
}
