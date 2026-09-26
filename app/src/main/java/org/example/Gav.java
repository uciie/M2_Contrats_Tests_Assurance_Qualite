package org.example;

public record Gav(String group, String artifact, String version) {
    public static Gav parse(String gavString) {
        String[] parts = gavString.split(":");
        if (parts.length != 3 || parts[0].isBlank() || parts[1].isBlank() || parts[2].isBlank()) {
            throw new IllegalArgumentException("Invalid GAV string: " + gavString);
        }
        return new Gav(parts[0], parts[1], parts[2]);
    }
}