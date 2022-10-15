package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneNameChangedEvent extends SceneEvent<SceneNameChangedEvent.SpecificData> {

  protected SceneNameChangedEvent() {
    super(Intent.Scenes);
  }

  protected SceneNameChangedEvent(SceneNameChangedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneEvent.SpecificData {

    private String oldSceneName;
  }
}
