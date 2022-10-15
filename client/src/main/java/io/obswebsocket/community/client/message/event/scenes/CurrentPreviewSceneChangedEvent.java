package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentPreviewSceneChangedEvent extends SceneEvent<SceneEvent.SpecificData> {

  protected CurrentPreviewSceneChangedEvent() {
    super(Intent.Scenes);
  }

  protected CurrentPreviewSceneChangedEvent(SceneEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }
}
