package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentProgramSceneChangedEvent extends SceneEvent<SceneEvent.SpecificData> {

  protected CurrentProgramSceneChangedEvent() {
    super(Intent.Scenes);
  }

  protected CurrentProgramSceneChangedEvent(SceneEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }
}
