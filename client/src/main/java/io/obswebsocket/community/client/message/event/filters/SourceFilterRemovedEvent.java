// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A filter has been removed from a source.
 */
@Getter
@ToString(
    callSuper = true
)
public class SourceFilterRemovedEvent extends Event<SourceFilterRemovedEvent.SpecificData> {
  protected SourceFilterRemovedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterRemovedEvent(SourceFilterRemovedEvent.SpecificData data) {
    super(Intent.Filters, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the source the filter was on
     */
    @NonNull
    private String sourceName;

    /**
     * Name of the filter
     */
    @NonNull
    private String filterName;
  }
}
