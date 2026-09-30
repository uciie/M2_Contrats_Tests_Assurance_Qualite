package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

    /**
     * Construit une coordonnée à partir d'une chaîne valide
     * Verifier la validité du groupe, de l'artifact et de la version
     * Utilisation de Hamcrest pour les assertions
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/validGavData.csv")
    void constructValidGavCheckAll_Hamcrest(String gavString, String expectedGroup, String expectedArtifact, String expectedVersion) {
        Gav gav = Gav.parse(gavString);
        assertThat(gav.group(), is(expectedGroup));
        assertThat(gav.artifact(), is(expectedArtifact));
        assertThat(gav.version(), is(expectedVersion));
    }

    /**
     * Faire un test qui echoue avec assertEquals
     */
    @Test 
    void demo_fail_assertEquals() {
        Gav gav = Gav.parse("org.acme:lib-a:1.0.0");
        assertEquals("com.example", gav.group(), "The group should be org.acme");
        assertEquals("my-artifact", gav.artifact(), "The artifact should be lib-a");
        assertEquals("1.0.1", gav.version(), "The version should be 1.0.0"); // This will fail
    }
    
    /**
     * Faire un test qui echoue avec assertThat
     */
    @Test 
    void demo_fail_assertThat() {
        Gav gav = Gav.parse("org.acme:lib-a:1.0.0");
        assertThat("The group should be org.acme", gav.group(), is("com.example"));
        assertThat("The artifact should be lib-a", gav.artifact(), is("my-artifact"));
        assertThat("The version should be 1.0.0", gav.version(), is("1.0.1")); // This will fail
    }
}