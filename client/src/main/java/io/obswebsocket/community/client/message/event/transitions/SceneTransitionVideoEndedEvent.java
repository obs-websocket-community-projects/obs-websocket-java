package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneTransitionVideoEndedEvent extends
    SceneTransitionEvent<SceneTransitionEvent.SpecificData> {

  protected SceneTransitionVideoEndedEvent() {
    super(Intent.Transitions);
  }

  protected SceneTransitionVideoEndedEvent(SpecificData data) {
    super(Intent.Transitions, data);
  }
}
