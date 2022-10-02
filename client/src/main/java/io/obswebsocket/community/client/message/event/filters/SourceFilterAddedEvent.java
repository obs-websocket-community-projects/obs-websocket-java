package io.obswebsocket.community.client.message.event.filters;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SourceFilterAddedEvent extends SourceFilterEvent {
  protected SourceFilterAddedEvent() {
    super(Intent.Filters);
  }
}
