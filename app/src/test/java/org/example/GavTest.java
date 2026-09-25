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

    /**
     * Construit une coordonnée à partir d'une chaîne valide
     * Verifier la validité du groupe, de l'artifact et de la version
     */
    @Test
    void constructValidGavCheckAll() {
        Gav gav = Gav.parse("org.other:lib-c:3.0.0");
        assertEquals("org.other", gav.group(), "The group should be org.other");
        assertEquals("lib-c", gav.artifact(), "The artifact should be lib-c");
        assertEquals("3.0.0", gav.version(), "The version should be 3.0.0");
    }
}