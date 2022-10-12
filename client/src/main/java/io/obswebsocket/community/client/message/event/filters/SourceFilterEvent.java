package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class SourceFilterEvent extends Event<SourceFilterEvent.SpecificData> {
  protected SourceFilterEvent(Intent intent) {
    super(intent);
  }

  @Getter
  @ToString
  public static class SpecificData {
    private String sourceName; // TODO SourceFilterEvent.Data
    private String filterName; // TODO SourceFilterEvent.Data
  }
}
