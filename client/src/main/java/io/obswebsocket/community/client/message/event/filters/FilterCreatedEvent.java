package io.obswebsocket.community.client.message.event.filters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class FilterCreatedEvent extends FilterEvent<FilterEvent.SpecificData> {
  protected FilterCreatedEvent() {
    super(Intent.Filters);
  }
}
