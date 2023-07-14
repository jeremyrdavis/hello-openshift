package com.redhat.greetings.ai.api.infrastructure;

import com.redhat.greetings.ai.api.AIAPI;
import com.redhat.greetings.domain.GreetingDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AIImpl implements AIAPI {

    List<String> unFriendlyWords = new ArrayList<>(){{
        add("VMWare");
        add("Rancher");
        add("Ubuntu");
    }};
    @Override
    public boolean isFamilyFriendly(GreetingDTO greetingDTO) {
        boolean isFamilyFriendly;
        for (String word : unFriendlyWords) {
            if (greetingDTO.text().contains(word)) {
                return false;
            }
        }
        return true;
    }
}
