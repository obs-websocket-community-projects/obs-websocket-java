package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSCommunicator;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.test.responses.DummyResponse;
import org.junit.jupiter.api.Test;

class OBSCommunicatorTest {

  @Test
  void testOnErrorCallbackOnInvalidJsonMessage() {
//        OBSCommunicator connector = new OBSCommunicator(true);

    AtomicReference<String> actualTestResult = new AtomicReference<>();

    // Given the communicator is listening for errors
    OBSCommunicator connector = OBSCommunicator.builder()
      .lifecycle()
        .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
      .and()
      .build();

//    connector.registerOnError(((message, throwable) -> actualTestResult.set(message)));

    // When an invalid JSON message is supplied
    connector.onMessage("x");

    // Then an error will have been received
    assertEquals("Received message had unknown format", actualTestResult.get());
  }

    @Test
    void testOnErrorCallbackOnInvalidResponseBaseClass() {
//        OBSCommunicator connector = new OBSCommunicator(true);

      AtomicReference<String> actualTestResult = new AtomicReference<>();

      // Given the communicator is listening for errors
      OBSCommunicator connector = OBSCommunicator.builder()
        .lifecycle()
        .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
        .and()
        .build();

//      connector.registerOnError(((message, throwable) -> actualTestResult.set(message)));

      // And given an unrecognized request was made at an earlier point, whereby
      // an unknown response type that extends Message was registered
//      String messageId = UUID.randomUUID().toString();
//      connector.messageTypes.put(messageId, DummyResponse.class);

      // When OBS supplies a Message for the unknown message's ID
      String message = "{\n"
        + "\t\"message-id\": \"" + UUID.randomUUID() + "\",\n"
        + "\t\"messageType\": \"SomethingGibberish\"\n"
        + "}";
      connector.onMessage(message);

      // Then an error will be received
      assertEquals("Received message had unknown format", actualTestResult.get());

    }

    // Not sure what this is supposed to test, there are no assertions or comments...
//    @Test
//    void testUnsupportedEventReceived() {
//        OBSCommunicator connector = new OBSCommunicator(true);
//
//        connector.registerOnError(null);
//
//        connector.onMessage("{'update-type': 'DOES_NOT_EXIST'}");
//    }

}
