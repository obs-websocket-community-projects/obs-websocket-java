package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneTransitionEndedEvent extends
    SceneTransitionEvent<SceneTransitionEvent.SpecificData> {

  protected SceneTransitionEndedEvent() {
    super(Intent.Transitions);
  }
}
