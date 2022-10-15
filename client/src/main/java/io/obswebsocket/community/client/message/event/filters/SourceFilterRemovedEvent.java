package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.filters.SourceFilterEvent.SpecificData;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterRemovedEvent extends SourceFilterEvent<SpecificData> {

  protected SourceFilterRemovedEvent() {
    super(Intent.Filters);
  }

  protected SourceFilterRemovedEvent(SpecificData data) {
    super(Intent.Filters, data);
  }
}
