package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneCollectionListChangedEvent extends
    Event<SceneCollectionListChangedEvent.SpecificData> {

  protected SceneCollectionListChangedEvent() {
    super(Intent.Config);
  }

  protected SceneCollectionListChangedEvent(SpecificData data) {
    super(Intent.Config, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    @Singular
    private List<String> sceneCollections;
  }
}
