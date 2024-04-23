package hello;

import static org.junit.Assert.assertEquals;
import org.joda.time.LocalTime;
import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void testGetCurrentTime() {
        LocalTime expectedTime = new LocalTime().withMillisOfSecond(0); // Truncate milliseconds
        LocalTime currentTime = HelloWorld.getCurrentTime().withMillisOfSecond(0); // Truncate milliseconds
        assertEquals(expectedTime, currentTime);
    }

    @Test
    public void testGetMessage() {
        String expectedMessage = "DevOps Project for Bosch Global Software Technology";
        String message = HelloWorld.getMessage();
        assertEquals(expectedMessage, message);
    }
}

