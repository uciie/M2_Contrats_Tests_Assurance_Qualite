package org.example;

public record Gav(String group, String artifact, String version) {
    public static Gav parse(String gavString) {
        // Triangulaire
        String[] parts = gavString.split(":");
        return new Gav(parts[0], parts[1], parts[2]);
    }
}