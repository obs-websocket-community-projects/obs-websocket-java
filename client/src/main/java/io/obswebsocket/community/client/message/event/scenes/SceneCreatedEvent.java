package io.obswebsocket.community.client.message.event.scenes;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneCreatedEvent extends SceneEvent<SceneCreatedEvent.SpecificData> {

  protected SceneCreatedEvent() {
    super(Intent.Scenes);
  }

  protected SceneCreatedEvent(SpecificData data) {
    super(Intent.Scenes, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneEvent.SpecificData {

    private Boolean isGroup;
  }
}
