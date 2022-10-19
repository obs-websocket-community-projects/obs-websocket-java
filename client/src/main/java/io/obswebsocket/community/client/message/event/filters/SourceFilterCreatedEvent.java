package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * A filter has been added to a source.
 * <p>
 * This class is generated, do not edit!
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

  @Getter
  @ToString
  @Builder
  public static class SpecificData {

    /**
     * Name of the source the filter was added to
     */
    @NonNull
    private String sourceName;

    /**
     * Name of the filter
     */
    @NonNull
    private String filterName;

    /**
     * The kind of the filter
     */
    @NonNull
    private String filterKind;

    /**
     * Index position of the filter
     */
    @NonNull
    private Number filterIndex;

    /**
     * The settings configured to the filter when it was created
     */
    @NonNull
    private JsonObject filterSettings;

    /**
     * The default settings for the filter
     */
    @NonNull
    private JsonObject defaultFilterSettings;
  }
}
