package com.redhat.greetings.domain;

import java.time.Instant;

public record GreetingDTO(Long id, String text, String author, SourceSystem sourceSystem, Instant createdAt, boolean isVerifiedFamilyFriendly) {

    public GreetingDTO(String text, String author, SourceSystem sourceSystem) {
        this(null, text, author, sourceSystem, null, false);
    }

    public GreetingDTO(String text, String author, SourceSystem sourceSystem, boolean isVerifiedFamilyFriendly) {
        this(null, text, author, sourceSystem, null, isVerifiedFamilyFriendly);
    }
}
