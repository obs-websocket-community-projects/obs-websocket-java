package net.twasi.obsremotejava.test;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.test.responses.DummyResponse;
import org.junit.jupiter.api.Test;

class OBSCommunicatorTest {

  @Test
  void todo() {
    fail("to do");
  }

//    @Test
//    void testOnErrorCallbackOnInvalidJsonMessage() {
//        OBSCommunicator connector = new OBSCommunicator(true);
//
//        AtomicReference<String> actualTestResult = new AtomicReference<>();
//
//        connector.registerOnError(((message, throwable) -> actualTestResult.set(message)));
//
//        connector.onMessage("x");
//
//        assertEquals("Received message had unknown format", actualTestResult.get());
//    }
//
//    @Test
//    void testOnErrorCallbackOnInvalidJsonMessageWithNullCallback() {
//        OBSCommunicator connector = new OBSCommunicator(true);
//
//        connector.registerOnError(null);
//
//        connector.onMessage("x");
//    }
//
//    @Test
//    void testOnErrorCallbackOnInvalidResponseBaseClass() {
//        OBSCommunicator connector = new OBSCommunicator(true);
//
//        AtomicReference<String> actualTestResult = new AtomicReference<>();
//
//        connector.registerOnError(((message, throwable) -> actualTestResult.set(message)));
//
//        connector.messageTypes.put("1", DummyResponse.class);
//        connector.onMessage("{'message-id': '1', 'status': '', 'error': ''}");
//
//        assertEquals("Invalid response type received", actualTestResult.get());
//    }
//
//    @Test
//    void testUnsupportedEventReceived() {
//        OBSCommunicator connector = new OBSCommunicator(true);
//
//        connector.registerOnError(null);
//
//        connector.onMessage("{'update-type': 'DOES_NOT_EXIST'}");
//    }

}
