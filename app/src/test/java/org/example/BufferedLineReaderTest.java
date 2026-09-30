package org.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringReader;
import org.example.BufferedLineReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BufferedLineReaderTest {

    @Test
    void testReadLine() throws IOException {
        String input = "Hello, World!\nThis is a test.";
        BufferedLineReader reader = new BufferedLineReader(new StringReader(input));

        String line1 = reader.readLine();
        String line2 = reader.readLine();

        assertEquals("Hello, World!", line1);
        assertEquals("This is a test.", line2);
    }
}