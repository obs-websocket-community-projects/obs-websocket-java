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

  @Test
  void currentSceneTransitionDurationChangedEvent() {
    assertEventType(TYPE, new CurrentSceneTransitionDurationChangedEvent(
        CurrentSceneTransitionDurationChangedEvent.SpecificData.builder()
            .transitionDuration(123L)
            .build()));
  }

  @Test
  void sceneTransitionStartedEvent() {
    assertEventType(TYPE, new SceneTransitionStartedEvent(
        SceneTransitionStartedEvent.SpecificData.builder()
            .transitionName("SomeName")
            .build()));
  }

  @Test
  void sceneTransitionEndedEvent() {
    assertEventType(TYPE, new SceneTransitionEndedEvent(
        SceneTransitionEndedEvent.SpecificData.builder()
            .transitionName("SomeName")
            .build()));
  }

  @Test
  void sceneTransitionVideoEndedEvent() {
    assertEventType(TYPE, new SceneTransitionVideoEndedEvent(
        SceneTransitionVideoEndedEvent.SpecificData.builder()
            .transitionName("SomeName")
            .build()));
  }
}
