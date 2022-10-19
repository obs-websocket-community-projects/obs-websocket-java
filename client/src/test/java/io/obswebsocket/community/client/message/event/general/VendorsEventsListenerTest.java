package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class VendorsEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void vendorEvent() {
    verifyEventListener(new VendorEventEvent());
  }
}
