package io.obswebsocket.community.client.message.event.scenes;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Scene;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneListChangedEvent extends Event<SceneListChangedEvent.SpecificData> {

  protected SceneListChangedEvent() {
    super(Intent.Scenes);
  }

  protected SceneListChangedEvent(SceneListChangedEvent.SpecificData data) {
    super(Intent.Scenes, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    @Singular
    private List<Scene> scenes;
  }
}
