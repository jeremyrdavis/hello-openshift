package com.redhat.greetings.domain;

import java.time.Instant;

public record GreetingDTO(Long id, String text, String author, SourceSystem sourceSystem, Instant createdAt, boolean isVerifiedFamilyFriendly) {

}
