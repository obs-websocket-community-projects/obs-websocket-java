package net.twasi.obsremotejava.test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.gson.Gson;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import net.twasi.obsremotejava.OBSCommunicator;
import org.junit.jupiter.api.Test;

class OBSCommunicatorTest {

  @Test
  void invalidJsonTriggersOnErrorCallback() {

    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
      .lifecycle()
        .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
      .and()
      .build();

    // When an invalid JSON message is supplied
    String message = "{x}";
    assertFalse(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will have been received
    assertThat(actualTestResult.get()).containsIgnoringCase("Message received was not valid json");

  }

  @Test
  void deserializableButUnrecognizedObjectsTriggerError() {

    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
      .lifecycle()
      .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
      .and()
      .build();

    // When a serializable (but unrecognized) object is supplied
    String message = "x";
    assertTrue(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will be triggered
    assertEquals("Received message was deserializable but had unknown format", actualTestResult.get());

  }

  @Test
  void validButUnrecognizedMessageTypeTriggersOnErrorCallback() {

    // Given the communicator is listening for errors
    AtomicReference<String> actualTestResult = new AtomicReference<>();
    OBSCommunicator connector = OBSCommunicator.builder()
      .lifecycle()
      .onError((comm, reasonThrowable) -> actualTestResult.set(reasonThrowable.getReason()))
      .and()
      .build();

    // When a valid, but unrecognized, JSON object is supplied
    String message = "{\n"
      + "\t\"message-id\": \"" + UUID.randomUUID() + "\",\n"
      + "\t\"messageType\": \"SomethingGibberish\"\n"
      + "}";
    assertTrue(isDeserializable(message));
    connector.onMessage(message);

    // Then an error will be triggered
    assertEquals("Received message was deserializable but had unknown format", actualTestResult.get());

  }

  private boolean isDeserializable(String json) {
    // We can use a generic gson object,
    // all we care about is if it is valid json
    Gson gson = new Gson();
    try {
      Object obj = gson.fromJson(json, Object.class);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
