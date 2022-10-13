package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterListReindexedEvent extends Event<SourceFilterListReindexedEvent.SpecificData> {
  protected SourceFilterListReindexedEvent() {
    super(Intent.Filters);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private List<Filter> filters;
  }
}
