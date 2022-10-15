package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class FiltersEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void sourceFilterListReindexedEvent() {
    verifyEventListener(new SourceFilterListReindexedEvent());
  }

  @Test
  void sourceFilterCreatedEvent() {
    verifyEventListener(new SourceFilterCreatedEvent());
  }

  @Test
  void sourceFilterRemovedEvent() {
    verifyEventListener(new SourceFilterRemovedEvent());
  }

  @Test
  void sourceFilterNameChangedEvent() {
    verifyEventListener(new SourceFilterNameChangedEvent());
  }

  @Test
  void sourceFilterEnableStateChangedEvent() {
    verifyEventListener(new SourceFilterEnableStateChangedEvent());
  }
}
