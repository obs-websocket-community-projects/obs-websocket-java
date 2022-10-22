// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * The name of a source filter has changed.
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

  /**
   * The source the filter is on
   *
   * @return the sourceName
   */
  public String getSourceName() {
    return getMessageData().getEventData().getSourceName();
  }

  /**
   * Old name of the filter
   *
   * @return the oldFilterName
   */
  public String getOldFilterName() {
    return getMessageData().getEventData().getOldFilterName();
  }

  /**
   * New name of the filter
   *
   * @return the filterName
   */
  public String getFilterName() {
    return getMessageData().getEventData().getFilterName();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The source the filter is on
     */
    private String sourceName;

    /**
     * Old name of the filter
     */
    private String oldFilterName;

    /**
     * New name of the filter
     */
    private String filterName;
  }
}
