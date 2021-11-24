package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class TransitionsEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void getPersistentDataRequest() {
    TransitionStartedEvent transitionStartedEvent = TransitionStartedEvent.builder()
        .transitionName("transition-started").build();

    String json = "{\n"
        + "\t'op': 5,\n"
        + "\t'd': {\n"
        + "\t\t'eventType': 'TransitionStarted',\n"
        + "\t\t'eventIntent': '" + (1 << 4) + "',\n"
        + "\t\t'eventData': {\n"
        + "\t\t\t'transitionName': 'transition-started'\n"
        + "\t\t}\n"
        + "\t}\n"
        + "}";

    assertSerializationAndDeserialization(json, transitionStartedEvent);
  }
}
