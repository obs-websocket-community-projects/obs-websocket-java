package io.obswebsocket.community.client.message.event.transitions;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneTransitionNameChangedEvent extends
    SceneTransitionEvent<SceneTransitionNameChangedEvent.SpecificData> {

  protected SceneTransitionNameChangedEvent() {
    super(Intent.Transitions);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneTransitionEvent.SpecificData {

    private String oldTransitionName; // TODO TransitionNameChangedEvent.Data
  }
}
