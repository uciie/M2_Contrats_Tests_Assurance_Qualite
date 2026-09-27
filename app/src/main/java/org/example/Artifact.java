package org.example;

import java.util.Set;

public record Artifact(Gav gav, Set<String> dependencies) {
}