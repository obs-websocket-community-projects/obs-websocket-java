package io.obswebsocket.community.client.message.event.config;

import java.util.List;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneCollection;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneCollectionListChangedEvent extends Event<SceneCollectionListChangedEvent.SpecificData> {
  protected SceneCollectionListChangedEvent() {
    super(Intent.Config);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private List<SceneCollection> sceneCollections;
  }
}
