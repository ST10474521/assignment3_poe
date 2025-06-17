package MxolisiMaluleka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * JUnit 4 test class for Message.java
 */
public class MessageTest {

    private Message message;

    @Before
    public void setUp() {
        message = new Message("MSG123", "+27821234567", "Hello world", "Tester", "2025-06-11 12:00:00");
    }

    @After
    public void tearDown() throws Exception {
        // Clean up any stored file after test
        Files.deleteIfExists(Paths.get("messages.json"));
    }


    @Test
    public void testStoreMessage() {
        message.storeMessage();
        File file = new File("messages.json");
        assertTrue(file.exists());

        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            assertTrue(content.contains("MSG123"));
            assertTrue(content.contains("Hello world"));
        } catch (Exception e) {
            fail("Could not read or verify messages.json");
        }
    }

    @Test
    public void testToString() {
        String result = message.toString();
        assertTrue(result.contains("Message ID: MSG123"));
        assertTrue(result.contains("Recipient: +27821234567"));
        assertTrue(result.contains("Hello world"));
    }
}
