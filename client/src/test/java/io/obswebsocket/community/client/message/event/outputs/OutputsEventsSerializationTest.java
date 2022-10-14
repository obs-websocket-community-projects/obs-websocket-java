package io.obswebsocket.community.client.message.event.outputs;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class OutputsEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void streamStateChangedEvent() {
    StreamStateChangedEvent streamStateChangedEvent = new StreamStateChangedEvent(
        StreamStateChangedEvent.SpecificData.builder()
            .outputActive(true)
            .outputState("streaming")
            .build());

    String json = this.readResourceFile("events/outputs/StreamStateChanged.json");

    assertSerializationAndDeserialization(json, streamStateChangedEvent);
  }
}
