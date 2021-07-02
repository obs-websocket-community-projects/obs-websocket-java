package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentPreviewSceneChangedEvent extends SceneChangedEvent {

  protected CurrentPreviewSceneChangedEvent() {
    super(Type.CurrentPreviewSceneChanged, Category.Scenes);
  }
}
