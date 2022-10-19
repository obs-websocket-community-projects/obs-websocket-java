package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A source filter's enable state has changed.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class SourceFilterEnableStateChangedEvent extends Event<SourceFilterEnableStateChangedEvent.SpecificData> {
  protected SourceFilterEnableStateChangedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterEnableStateChangedEvent(
      SourceFilterEnableStateChangedEvent.SpecificData data) {
    super(Intent.Filters, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the source the filter is on
     */
    @NonNull
    private String sourceName;

    /**
     * Name of the filter
     */
    @NonNull
    private String filterName;

    /**
     * Whether the filter is enabled
     */
    @NonNull
    private Boolean filterEnabled;
  }
}
