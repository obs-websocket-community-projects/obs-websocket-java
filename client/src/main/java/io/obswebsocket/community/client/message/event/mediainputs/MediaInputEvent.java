package io.obswebsocket.community.client.message.event.mediainputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class MediaInputEvent extends Event {

  private final transient Data messageData;

  protected MediaInputEvent(Type eventType, Intent intent) {
    super(eventType, intent);

    this.messageData = Data.builder().eventType(eventType).eventIntent(intent).build();
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String inputName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {
    protected transient SpecificData eventData;
  }
}
