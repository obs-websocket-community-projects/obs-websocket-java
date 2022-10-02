package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneCreatedEvent extends SceneEvent<SceneCreatedEvent.SpecificData> {
  protected SceneCreatedEvent() {
    super(Intent.Scenes);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneEvent.SpecificData {
    private Boolean isGroup;
  }
}
