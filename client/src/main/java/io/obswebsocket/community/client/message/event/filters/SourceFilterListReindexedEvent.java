// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

/**
 * A source's filter list has been reindexed.
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

  /**
   * Name of the source
   *
   * @return the sourceName
   */
  public String getSourceName() {
    return getMessageData().getEventData().getSourceName();
  }

  /**
   * Array of filter objects
   *
   * @return the filters
   */
  public List<Filter> getFilters() {
    return getMessageData().getEventData().getFilters();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the source
     */
    private String sourceName;

    /**
     * Array of filter objects
     */
    @Singular
    private List<Filter> filters;
  }
}
