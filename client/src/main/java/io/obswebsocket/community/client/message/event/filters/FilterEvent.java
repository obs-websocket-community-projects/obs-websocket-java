package io.obswebsocket.community.client.message.event.filters;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class FilterEvent extends Event {

  private final transient Data messageData;

  protected FilterEvent(Type eventType, Intent intent) {
    super(eventType, intent);

    this.messageData = Data.builder().eventType(eventType).eventIntent(intent).build();
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String filterName; // TODO FilterEvent.Data
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected transient SpecificData eventData;
  }
}
