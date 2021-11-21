package io.obswebsocket.community.client.message.event.scenes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CurrentProgramSceneChangedEvent extends SceneEvent {

  @SerializedName("d")
  private final Data messageData;

  protected CurrentProgramSceneChangedEvent() {
    super(Type.CurrentProgramSceneChanged, Intent.Scenes);

    SceneEvent.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneEvent.Data {

    protected SceneEvent.SpecificData eventData;
  }
}
