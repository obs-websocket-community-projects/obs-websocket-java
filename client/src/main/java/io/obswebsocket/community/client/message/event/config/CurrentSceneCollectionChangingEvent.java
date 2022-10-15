package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneCollectionChangingEvent extends
    Event<CurrentSceneCollectionChangingEvent.SpecificData> {

  protected CurrentSceneCollectionChangingEvent() {
    super(Intent.Config);
  }

  protected CurrentSceneCollectionChangingEvent(SpecificData data) {
    super(Intent.Config, data);
  }

  @Getter
  @ToString
  @Builder(access = AccessLevel.PROTECTED)
  public static class SpecificData {

    private String sceneCollectionName;
  }
}
