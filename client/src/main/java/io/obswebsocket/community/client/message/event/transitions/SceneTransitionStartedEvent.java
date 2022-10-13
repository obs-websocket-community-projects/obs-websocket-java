package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneTransitionStartedEvent extends
    SceneTransitionEvent<SceneTransitionEvent.SpecificData> {

  protected SceneTransitionStartedEvent() {
    super(Intent.Transitions);
  }

  protected SceneTransitionStartedEvent(SceneTransitionEvent.SpecificData data) {
    super(Intent.Transitions, data);
  }
}
