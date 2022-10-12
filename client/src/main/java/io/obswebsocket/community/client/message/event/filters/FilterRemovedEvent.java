package io.obswebsocket.community.client.message.event.filters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class FilterRemovedEvent extends FilterEvent<FilterEvent.SpecificData> {
  protected FilterRemovedEvent() {
    super(Intent.Filters);
  }
}
