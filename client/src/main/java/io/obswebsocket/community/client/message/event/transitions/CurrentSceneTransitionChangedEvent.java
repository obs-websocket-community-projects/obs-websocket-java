package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneTransitionChangedEvent extends
    SceneTransitionEvent<SceneTransitionEvent.SpecificData> {

  protected CurrentSceneTransitionChangedEvent() {
    super(Intent.Transitions);
  }
}
