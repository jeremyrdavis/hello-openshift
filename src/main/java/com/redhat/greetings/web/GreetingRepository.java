package com.redhat.greetings.web;


import com.redhat.greetings.domain.GreetingDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingRepository implements PanacheRepository<Greeting> {

    GreetingDTO persist(GreetingDTO greetingDTO) {
        Greeting greeting = new Greeting(greetingDTO.text(), greetingDTO.author(), greetingDTO.sourceSystem(), greetingDTO.createdAt(), greetingDTO.isVerifiedFamilyFriendly());
        greeting.persist();
        return new GreetingDTO(greeting.id, greeting.text, greeting.author, greeting.sourceSystem, greeting.createdAt, greeting.isFamilyFriendly);
    }
}
