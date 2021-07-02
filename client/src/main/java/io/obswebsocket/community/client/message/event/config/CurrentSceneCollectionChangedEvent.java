package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneCollectionChangedEvent extends Event {

  private Data eventData;

  protected CurrentSceneCollectionChangedEvent() {
    super(Type.CurrentSceneCollectionChanged, Category.Config);
  }

  @Getter
  @ToString
  public static class Data {

    private String currentSceneCollectionName;
  }
}
