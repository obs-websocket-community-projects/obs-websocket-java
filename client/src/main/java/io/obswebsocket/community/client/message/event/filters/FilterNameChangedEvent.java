package io.obswebsocket.community.client.message.event.filters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class FilterNameChangedEvent extends FilterEvent<FilterNameChangedEvent.SpecificData> {
  protected FilterNameChangedEvent() {
    super(Intent.Filters);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends FilterEvent.SpecificData {
    private String oldFilterName;
  }
}
