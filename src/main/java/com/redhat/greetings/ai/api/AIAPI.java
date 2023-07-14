package com.redhat.greetings.ai.api;

import com.redhat.greetings.domain.GreetingDTO;

public interface AIAPI {

    public boolean isFamilyFriendly(GreetingDTO greetingDTO);
}
