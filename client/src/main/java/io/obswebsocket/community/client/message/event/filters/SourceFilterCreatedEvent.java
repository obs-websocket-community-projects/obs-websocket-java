package io.obswebsocket.community.client.message.event.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.event.filters.SourceFilterEvent.SpecificData;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SourceFilterCreatedEvent extends SourceFilterEvent<SpecificData> {

  protected SourceFilterCreatedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterCreatedEvent(SourceFilterEvent.SpecificData data) {
    super(Intent.Filters, data);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class SpecificData extends SourceFilterEvent.SpecificData {

    private Integer filterIndex;
    private String filterKind;
    private JsonObject filterSettings;
    private JsonObject defaultFilterSettings;
  }
}
