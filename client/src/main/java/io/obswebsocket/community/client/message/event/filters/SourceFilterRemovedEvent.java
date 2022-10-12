package io.obswebsocket.community.client.message.event.filters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterRemovedEvent extends SourceFilterEvent {
  protected SourceFilterRemovedEvent() {
    super(Intent.Filters);
  }
}
