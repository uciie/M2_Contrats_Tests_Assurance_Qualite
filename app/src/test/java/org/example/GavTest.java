package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GavTest {

    /**
     * Construit une coordonnée à partir d'une chaîne valide
     * Verifier la validité du groupe, de l'artifact et de la version
     */
    @ParameterizedTest
    @CsvSource({
        "org.acme:lib-a:1.0.0, org.acme, lib-a, 1.0.0",
        "org.other:lib-c:3.0.0, org.other, lib-c, 3.0.0"
    })
    void constructValidGavCheckAll(String gavString, String expectedGroup, String expectedArtifact, String expectedVersion) {
        Gav gav = Gav.parse(gavString);
        assertEquals(expectedGroup, gav.group(), "The group should be " + expectedGroup);
        assertEquals(expectedArtifact, gav.artifact(), "The artifact should be " + expectedArtifact);
        assertEquals(expectedVersion, gav.version(), "The version should be " + expectedVersion);
    }
}