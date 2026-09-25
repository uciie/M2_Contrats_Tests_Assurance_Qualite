package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GavTest {

    /**
     * Construit une coordonnée à partir d'une chaîne valide
     * Verifier la validité du group
     */
    @Test 
    void constructValidGavCheckGroup() {
        Gav gav = Gav.parse("org.acme:lib-a:1.0.0");
        assertEquals("org.acme", gav.group(), "The group should be org.acme");
    }
}