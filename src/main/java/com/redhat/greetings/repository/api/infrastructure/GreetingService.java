package com.redhat.greetings.repository.api.infrastructure;

import com.redhat.greetings.domain.GreetingDTO;
import com.redhat.greetings.repository.api.GreetingRepositoryAPI;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class GreetingService implements GreetingRepositoryAPI {
    @Override
    public void addGreeting(GreetingDTO greetingDTO) {

    }

    @Override
    public List<GreetingDTO> allGreetings() {
        return null;
    }
}
