package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import org.junit.jupiter.api.Test;

class HighVolumeEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "highvolume";

  @Test
  void inputActiveStateChangedEvent() {
    assertEventType(TYPE, new InputActiveStateChangedEvent(
        InputActiveStateChangedEvent.SpecificData.builder()
            .inputName("SomeName")
            .videoActive(true)
            .build()));
  }
}
