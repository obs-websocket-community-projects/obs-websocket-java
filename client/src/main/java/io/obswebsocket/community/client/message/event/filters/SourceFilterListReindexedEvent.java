package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * A source's filter list has been reindexed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SourceFilterListReindexedEvent extends Event<SourceFilterListReindexedEvent.SpecificData> {
  protected SourceFilterListReindexedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterListReindexedEvent(SourceFilterListReindexedEvent.SpecificData data) {
    super(Intent.Filters, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the source
     */
    @NonNull
    private String sourceName;

    /**
     * Array of filter objects
     */
    @NonNull
    @Singular
    private List<Filter> filters;
  }
}
