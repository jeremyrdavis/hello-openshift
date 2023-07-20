package com.redhat.greetings.cqrs.api.domain;

import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.domain.SourceSystem;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class GreetingTest {

    private String text = "Rock 'n Roll!";
    private String author = "Angus Young";
    private SourceSystem sourceSystem = SourceSystem.REST_API;
    private Instant createdAt = Instant.now();

    @Test
    public void testToString() {

        String result = new Greeting(
                text,
                author,
                sourceSystem,
                createdAt,
                false).toString();

        assertTrue(result.contains(text));
        assertTrue(result.contains(author));
        assertTrue(result.contains(String.valueOf(sourceSystem)));
        assertTrue(result.contains(String.valueOf(createdAt)));
        assertTrue(result.contains("false"));

    }

    @Test
    public void testFromDTO() {
        Greeting greeting = Greeting.fromGreetingDTO(new GreetingDTO(
                1L, text, author, sourceSystem, createdAt, false
        ));

        assertEquals(text, greeting.text);
        assertEquals(author, greeting.author);
        assertEquals(sourceSystem, greeting.sourceSystem);
        assertEquals(createdAt, greeting.createdAt);
        assertFalse(greeting.isVerifiedFamilyFriendly);
    }

    @Test
    public void testCanonicalConstructor() {

        Greeting greeting = new Greeting(
                text,
                author,
                sourceSystem,
                createdAt,
                false);

        assertEquals(text, greeting.text);
        assertEquals(author, greeting.author);
        assertEquals(sourceSystem, greeting.sourceSystem);
        assertEquals(createdAt, greeting.createdAt);
        assertFalse(greeting.isVerifiedFamilyFriendly);
    }
}
