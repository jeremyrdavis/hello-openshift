package com.redhat.greetings.ai.api;

import com.redhat.greetings.domain.GreetingDTO;

import java.util.ArrayList;
import java.util.List;

public interface AIAPI {

    public boolean isFamilyFriendly(GreetingDTO greetingDTO);
}
