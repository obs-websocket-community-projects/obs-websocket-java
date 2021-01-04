package net.twasi.obsremotejava.test;

import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.requests.ResponseBase;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OBSCommunicatorTest {

    @Test
    void testOnErrorCallbackOnInvalidJsonMessage() {
        OBSCommunicator connector = new OBSCommunicator(true);

        AtomicReference<String> actualTestResult = new AtomicReference<>();

        connector.registerOnError(((message, throwable) -> actualTestResult.set(message)));

        connector.onMessage("x");

        assertEquals("Failed to process message from websocket", actualTestResult.get());
    }

    @Test
    void testOnErrorCallbackOnInvalidJsonMessageWithNullCallback() {
        OBSCommunicator connector = new OBSCommunicator(true);

        connector.registerOnError(null);

        connector.onMessage("x");
    }

    @Test
    void testOnErrorCallbackOnInvalidResponseBaseClass() {
        OBSCommunicator connector = new OBSCommunicator(true);

        AtomicReference<String> actualTestResult = new AtomicReference<>();

        connector.registerOnError(((message, throwable) -> actualTestResult.set(message)));

        connector.messageTypes.put("1", ResponseBase.class);
        connector.onMessage("{'message-id': '1', 'status': '', 'error': ''}");

        assertEquals("Invalid response type received", actualTestResult.get());
    }

}
