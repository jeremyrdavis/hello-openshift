package com.redhat.greetings.ai.api.infrastructure;

import com.redhat.greetings.ai.AIImpl;
import com.redhat.greetings.domain.GreetingDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AITest {

    @Test
    public void testAI() {

        AIImpl ai = new AIImpl();
        assertFalse(ai.isFamilyFriendly(new GreetingDTO(null, "VMWare is the best!", null, null, null, false)));
        assertFalse(ai.isFamilyFriendly(new GreetingDTO(null, "Rancher is awesome!", null, null, null, false)));
        assertFalse(ai.isFamilyFriendly(new GreetingDTO(null, "Ubuntu IS Linux", null, null, null, false)));
        assertTrue(ai.isFamilyFriendly(new GreetingDTO(null, "Red Hat", null, null, null, false)));
    }
}
