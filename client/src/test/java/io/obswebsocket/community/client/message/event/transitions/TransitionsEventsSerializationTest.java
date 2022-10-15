package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.AbstractEventSerializationTest;
import org.junit.jupiter.api.Test;

public class TransitionsEventsSerializationTest extends AbstractEventSerializationTest {

  private static final String TYPE = "transitions";

  @Test
  void currentSceneTransitionChangedEvent() {
    assertEventType(TYPE, new CurrentSceneTransitionChangedEvent(
        CurrentSceneTransitionChangedEvent.SpecificData.builder()
            .transitionName("SomeName")
            .build()));
  }
}
