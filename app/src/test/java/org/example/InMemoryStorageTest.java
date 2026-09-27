package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import java.util.Set;
import org.example.interfaces.IStorage;

class InMemoryStorageTest {

    private IStorage storage; // typé par l'interface

    @BeforeEach
    void init() {
        storage = new InMemoryStorage();
    }

    /**
     * Teste la récupération d'un élément dans le stockage, get
     */
    @ParameterizedTest
    @CsvSource({
        "org.acme:lib-a:1.0.0",
        "org.other:lib-c:3.0.0"
    })
    void testGet(String gavString) {
        Gav gav = Gav.parse(gavString);
        Optional<Artifact> artifact = storage.get(gav);
        assertTrue(artifact.isEmpty());
    }

    /**
     * Teste l'ajout d'un élément dans le stockage, put
     */
    @ParameterizedTest
    @CsvSource({
        "org.acme:lib-a:1.0.0",
        "org.other:lib-c:3.0.0"
    })
    void testPut(String gavString) {
        Gav gav = Gav.parse(gavString);
        Artifact artifact = new Artifact(gav, Set.of());
        
        storage.put(gav, artifact);
        Optional<Artifact> result = storage.get(gav);
        System.out.println("Result: " + result);
        System.out.println("Expected: " + Optional.of(artifact));
        assertEquals(Optional.of(artifact), result);
    }
    
}