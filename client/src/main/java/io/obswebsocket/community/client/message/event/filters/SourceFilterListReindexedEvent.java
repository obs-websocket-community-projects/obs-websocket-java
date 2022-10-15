package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterListReindexedEvent extends
    Event<SourceFilterListReindexedEvent.SpecificData> {

  protected SourceFilterListReindexedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterListReindexedEvent(SpecificData data) {
    super(Intent.Filters, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    private String sourceName;
    @Singular
    private List<Filter> filters;
  }
}
