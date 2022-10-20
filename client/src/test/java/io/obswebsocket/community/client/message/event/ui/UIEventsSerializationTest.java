package io.obswebsocket.community.client.message.event.ui;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class UIEventsSerializationTest extends AbstractSerializationTest {

  @Test
  void studioModeStateChangedEvent() {
    StudioModeStateChangedEvent studioModeStateChangedEvent = new StudioModeStateChangedEvent(
        StudioModeStateChangedEvent.SpecificData.builder()
            .studioModeEnabled(true)
            .build());

    String json = this.readResourceFile("events/ui/StudioModeStateChanged.json");

    assertSerializationAndDeserialization(json, studioModeStateChangedEvent);
  }
}
