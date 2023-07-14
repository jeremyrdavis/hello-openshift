package com.redhat.greetings.web;

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

    boolean isFamilyFriendly;

    public Greeting(String text, String author, SourceSystem sourceSystem, Instant createdAt, boolean isFamilyFriendly) {
        this.text = text;
        this.author = author;
        this.sourceSystem = sourceSystem;
        this.createdAt = createdAt;
        this.isFamilyFriendly = isFamilyFriendly;
    }

    public Greeting() {

    }

    @Override
    public String toString() {
        return "Greeting{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", sourceSystem=" + sourceSystem +
                ", createdAt=" + createdAt +
                ", isFamilyFriendly=" + isFamilyFriendly +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Greeting other = (Greeting) o;
        return id != null && id.equals(other);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}