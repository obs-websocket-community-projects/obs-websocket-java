package io.obswebsocket.community.client.message.event.scenes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneCreatedEvent extends SceneEvent {

  @SerializedName("d")
  private final Data messageData;

  protected SceneCreatedEvent() {
    super(Type.SceneCreated, Intent.Scenes);

    SceneEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneEvent.SpecificData {

    private Boolean isGroup;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneEvent.Data {

    protected SpecificData eventData;
  }
}
