package io.obswebsocket.community.client.message.event.transitions;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneTransitionEvent<T extends SceneTransitionEvent.SpecificData> extends Event<T> {

  protected SceneTransitionEvent(Intent intent) {
    super(intent);
  }

  protected SceneTransitionEvent(Intent intent, T data) {
    super(intent, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData {
    protected String transitionName; // TODO TransitionEvent.Data
  }
}
