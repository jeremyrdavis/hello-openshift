package com.redhat.greetings;

import java.time.Instant;

public record GreetingDTO(Long id, String text, String author, SourceSystem sourceSystem, Instant createdAt) {

    public GreetingDTO(Long id, String text, String author, SourceSystem sourceSystem, Instant createdAt) {
        this.id = id;
        this.text = text;
        this.author = author;
        if (sourceSystem == null) {
            this.sourceSystem = SourceSystem.REST_API;
        }else{
            this.sourceSystem = sourceSystem;
        }
        if(createdAt == null){
            this.createdAt = Instant.now();
        }else{
            this.createdAt = createdAt;
        }
    }
}
