package io.obswebsocket.community.client.message.event.config;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentProfileChangedEvent extends Event {

  private Data eventData;

  protected CurrentProfileChangedEvent() {
    super(Type.CurrentProfileChanged, Category.Config);
  }

  @Getter
  @ToString
  public static class Data {

    private String currentProfileName;
  }
}
