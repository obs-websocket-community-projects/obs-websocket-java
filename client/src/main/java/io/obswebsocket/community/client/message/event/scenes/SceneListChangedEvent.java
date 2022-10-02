package io.obswebsocket.community.client.message.event.scenes;

import java.util.List;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Scene;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneListChangedEvent extends Event<SceneListChangedEvent.SpecificData> {
  protected SceneListChangedEvent() {
    super(Intent.Scenes);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private List<Scene> scenes;
  }
}
