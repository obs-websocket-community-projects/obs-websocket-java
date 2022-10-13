package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneTransitionRemovedEvent extends
    SceneTransitionEvent<SceneTransitionEvent.SpecificData> {

  protected SceneTransitionRemovedEvent() {
    super(Intent.Transitions);
  }
}
