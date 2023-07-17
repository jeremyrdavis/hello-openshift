package com.redhat.greetings.repository.api.domain;

import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.domain.SourceSystem;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.Instant;

@Entity
public class Greeting extends PanacheEntity {

    String text;

    String author;

    SourceSystem sourceSystem;

    Instant createdAt;

    boolean isVerifiedFamilyFriendly;

    public Greeting() {
    }

    public Greeting(String text, String author, SourceSystem sourceSystem, Instant createdAt, boolean isVerifiedFamilyFriendly) {
        this.text = text;
        this.author = author;
        this.sourceSystem = sourceSystem;
        this.createdAt = createdAt;
        this.isVerifiedFamilyFriendly = isVerifiedFamilyFriendly;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", sourceSystem=" + sourceSystem +
                ", createdAt=" + createdAt +
                ", isVerifiedFamilyFriendly=" + isVerifiedFamilyFriendly +
                ", id=" + id +
                '}';
    }

    static Greeting fromGreetingDTO(GreetingDTO greetingDTO) {
        return new Greeting(
                greetingDTO.text(),
                greetingDTO.author(),
                greetingDTO.sourceSystem(),
                greetingDTO.createdAt(),
                greetingDTO.isVerifiedFamilyFriendly());
    }


}
