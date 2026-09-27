package org.example.interfaces;

import org.example.Artifact;
import org.example.Gav;
import java.util.Optional;

public interface IStorage {
    void put(Gav gav, Artifact artifact);
    Optional<Artifact> get(Gav gav);
}
