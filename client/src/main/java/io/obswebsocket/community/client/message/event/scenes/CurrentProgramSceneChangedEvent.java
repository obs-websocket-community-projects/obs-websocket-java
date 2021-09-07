package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentProgramSceneChangedEvent extends SceneEvent {

  private Data eventData;

  protected CurrentProgramSceneChangedEvent() {
    super(Type.CurrentProgramSceneChangedEvent, Category.Scenes);
  }
}
