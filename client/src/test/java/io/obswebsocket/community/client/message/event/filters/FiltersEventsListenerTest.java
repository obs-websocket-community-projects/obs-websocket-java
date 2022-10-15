package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class FiltersEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void sourceFilterListReindexedEvent() {
    verifyEventListener(new SourceFilterListReindexedEvent());
  }
}
