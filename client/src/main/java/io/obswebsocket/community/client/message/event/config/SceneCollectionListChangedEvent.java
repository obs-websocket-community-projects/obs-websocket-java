package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneCollection;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneCollectionListChangedEvent extends Event {

  private Data eventData;

  protected SceneCollectionListChangedEvent() {
    super(Type.SceneCollectionListChanged, Intent.Config);
  }

  @Getter
  @ToString
  public static class Data {

    private List<SceneCollection> sceneCollections;
  }
}
