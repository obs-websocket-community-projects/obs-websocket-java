package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class GeneralEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void exitStartedEvent() {
    ExitStartedEvent streamStateChangedEvent = new ExitStartedEvent();

    String json = this.readResourceFile("events/general/ExitStarted.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }
}
