package org.example;

import org.example.interfaces.ILineReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

public class BufferedLineReader implements ILineReader {
    private final BufferedReader reader;

    public BufferedLineReader(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }
}