package io.obswebsocket.community.client.message.event.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CurrentSceneCollectionChangedEvent extends Event {

  @SerializedName("d")
  private final Data messageData;

  protected CurrentSceneCollectionChangedEvent() {
    super(Type.CurrentSceneCollectionChanged, Intent.Config);

    Event.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType())
        .eventIntent(superData.getEventIntent()).build();
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String currentSceneCollectionName;
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
