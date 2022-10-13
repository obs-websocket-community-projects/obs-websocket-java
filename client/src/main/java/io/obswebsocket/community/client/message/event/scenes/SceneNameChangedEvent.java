package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneNameChangedEvent extends SceneEvent<SceneNameChangedEvent.SpecificData> {
  protected SceneNameChangedEvent() {
    super(Intent.Scenes);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneEvent.SpecificData {
    private String oldSceneName;
  }
}
