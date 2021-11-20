package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SceneItemSourceEvent extends SceneItemEvent {

  private final transient SceneItemEvent.Data messageData;

  protected SceneItemSourceEvent(Type eventType, Intent intent) {
    super(eventType, intent);

    this.messageData = Data.builder().eventType(eventType).eventIntent(intent).build();
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private String sourceName;
    private Integer sourceItemId;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneItemEvent.Data {

    protected transient SpecificData eventData;
  }
}
