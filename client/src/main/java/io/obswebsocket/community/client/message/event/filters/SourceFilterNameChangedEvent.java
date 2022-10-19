package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * The name of a source filter has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SourceFilterNameChangedEvent extends Event<SourceFilterNameChangedEvent.SpecificData> {
  protected SourceFilterNameChangedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterNameChangedEvent(SourceFilterNameChangedEvent.SpecificData data) {
    super(Intent.Filters, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The source the filter is on
     */
    @NonNull
    private String sourceName;

    /**
     * Old name of the filter
     */
    @NonNull
    private String oldFilterName;

    /**
     * New name of the filter
     */
    @NonNull
    private String filterName;
  }
}
