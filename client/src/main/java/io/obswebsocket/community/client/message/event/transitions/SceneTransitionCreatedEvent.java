package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneTransitionCreatedEvent extends
    SceneTransitionEvent<SceneTransitionEvent.SpecificData> {

  protected SceneTransitionCreatedEvent() {
    super(Intent.Transitions);
  }
}
