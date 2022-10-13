package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.filters.SourceFilterEvent.SpecificData;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SourceFilterEvent<T extends SpecificData> extends Event<T> {

  protected SourceFilterEvent(Intent intent) {
    super(intent);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String sourceName;
    private String filterName;
  }
}
