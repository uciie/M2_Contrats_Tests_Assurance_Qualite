package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.example.interfaces.IStorage;

public class InMemoryStorage implements IStorage {
    private final Map<Gav, Artifact> storage = new HashMap<>();

    @Override
    public void put(Gav gav, Artifact artifact) {
        storage.put(gav, artifact);
    }

    @Override
    public Optional<Artifact> get(Gav gav) {
        return Optional.ofNullable(storage.get(gav));
    }

}