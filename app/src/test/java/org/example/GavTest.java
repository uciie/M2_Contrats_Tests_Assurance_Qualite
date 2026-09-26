package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GavTest {

    /**
     * Construit une coordonnée à partir d'une chaîne valide
     * Verifier la validité du groupe, de l'artifact et de la version
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/validGavData.csv")
    void constructValidGavCheckAll(String gavString, String expectedGroup, String expectedArtifact, String expectedVersion) {
        Gav gav = Gav.parse(gavString);
        assertEquals(expectedGroup, gav.group(), "The group should be " + expectedGroup);
        assertEquals(expectedArtifact, gav.artifact(), "The artifact should be " + expectedArtifact);
        assertEquals(expectedVersion, gav.version(), "The version should be " + expectedVersion);
    }

    /**
     * Construit une coordonnée à partir d'une chaîne invalide
     * Verifier que la méthode parse lance une exception
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/invalidGavData.csv")
    void constructInvalidGavCheckException(String gavString) {
        assertThrows(IllegalArgumentException.class, () -> {
            Gav.parse(gavString);
        }, "Expected parse() to throw, but it didn't");
    }
}