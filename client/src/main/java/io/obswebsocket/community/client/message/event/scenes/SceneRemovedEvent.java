package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneRemovedEvent extends SceneEvent<SceneRemovedEvent.SpecificData> {
  protected SceneRemovedEvent() {
    super(Intent.Scenes);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneEvent.SpecificData {
    private Boolean isGroup;
  }
}
