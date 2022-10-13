package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneCollectionChangedEvent extends Event<CurrentSceneCollectionChangedEvent.SpecificData> {
  protected CurrentSceneCollectionChangedEvent() {
    super(Intent.Config);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String currentSceneCollectionName;
  }
}
