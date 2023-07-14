package com.redhat.greetings.repository.api;

import com.redhat.greetings.domain.GreetingDTO;

import java.util.List;

public interface GreetingRepositoryAPI {

    public void addGreeting(GreetingDTO greetingDTO);

    public List<GreetingDTO> allGreetings();
}
