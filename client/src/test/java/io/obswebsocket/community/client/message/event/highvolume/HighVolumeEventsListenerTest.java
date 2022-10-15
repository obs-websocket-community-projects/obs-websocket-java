package io.obswebsocket.community.client.message.event.highvolume;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class HighVolumeEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void inputActiveStateChangedEvent() {
    verifyEventListener(new InputActiveStateChangedEvent());
  }
}
