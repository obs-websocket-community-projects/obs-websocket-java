package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class FilterEvent<T extends FilterEvent.SpecificData> extends Event<T> {
  protected FilterEvent(Intent intent) {
    super(intent);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String filterName; // TODO FilterEvent.Data
  }
}
