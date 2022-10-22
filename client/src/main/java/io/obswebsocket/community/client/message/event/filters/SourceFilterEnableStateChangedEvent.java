// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A source filter's enable state has changed.
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

  /**
   * Name of the source the filter is on
   *
   * @return the sourceName
   */
  public String getSourceName() {
    return getMessageData().getEventData().getSourceName();
  }

  /**
   * Name of the filter
   *
   * @return the filterName
   */
  public String getFilterName() {
    return getMessageData().getEventData().getFilterName();
  }

  /**
   * Whether the filter is enabled
   *
   * @return the filterEnabled
   */
  public Boolean getFilterEnabled() {
    return getMessageData().getEventData().getFilterEnabled();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the source the filter is on
     */
    private String sourceName;

    /**
     * Name of the filter
     */
    private String filterName;

    /**
     * Whether the filter is enabled
     */
    private Boolean filterEnabled;
  }
}
