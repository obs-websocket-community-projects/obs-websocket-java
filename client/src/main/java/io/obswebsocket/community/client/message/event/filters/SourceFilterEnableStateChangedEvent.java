package io.obswebsocket.community.client.message.event.filters;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SourceFilterEnableStateChangedEvent extends
    SourceFilterEvent<SourceFilterEnableStateChangedEvent.SpecificData> {

  protected SourceFilterEnableStateChangedEvent() {
    super(Intent.Filters);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SourceFilterEvent.SpecificData {

    private Boolean filterEnabled;
  }
}
