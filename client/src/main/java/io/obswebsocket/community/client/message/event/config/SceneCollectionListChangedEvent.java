package io.obswebsocket.community.client.message.event.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.model.SceneCollection;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneCollectionListChangedEvent extends Event {

  @SerializedName("d")
  private final Data messageData;

  protected SceneCollectionListChangedEvent() {
    super(Type.SceneCollectionListChanged, Intent.Config);

    Event.Data superData = super.getMessageData();
    this.messageData = Data.builder().eventType(superData.getEventType()).eventIntent(
        superData.getEventIntent()).build();
  }

  @Getter
  @ToString
  public static class SpecificData {

    private List<SceneCollection> sceneCollections;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
