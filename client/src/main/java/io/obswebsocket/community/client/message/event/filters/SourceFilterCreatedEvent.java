// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A filter has been added to a source.
 */
@Getter
@ToString(
    callSuper = true
)
public class SourceFilterCreatedEvent extends Event<SourceFilterCreatedEvent.SpecificData> {
  protected SourceFilterCreatedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterCreatedEvent(SourceFilterCreatedEvent.SpecificData data) {
    super(Intent.Filters, data);
  }

  /**
   * Name of the source the filter was added to
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
   * The kind of the filter
   *
   * @return the filterKind
   */
  public String getFilterKind() {
    return getMessageData().getEventData().getFilterKind();
  }

  /**
   * Index position of the filter
   *
   * @return the filterIndex
   */
  public Number getFilterIndex() {
    return getMessageData().getEventData().getFilterIndex();
  }

  /**
   * The settings configured to the filter when it was created
   *
   * @return the filterSettings
   */
  public JsonObject getFilterSettings() {
    return getMessageData().getEventData().getFilterSettings();
  }

  /**
   * The default settings for the filter
   *
   * @return the defaultFilterSettings
   */
  public JsonObject getDefaultFilterSettings() {
    return getMessageData().getEventData().getDefaultFilterSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the source the filter was added to
     */
    private String sourceName;

    /**
     * Name of the filter
     */
    private String filterName;

    /**
     * The kind of the filter
     */
    private String filterKind;

    /**
     * Index position of the filter
     */
    private Number filterIndex;

    /**
     * The settings configured to the filter when it was created
     */
    private JsonObject filterSettings;

    /**
     * The default settings for the filter
     */
    private JsonObject defaultFilterSettings;
  }
}
