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
  private Data messageData;

  protected SceneCollectionListChangedEvent() {
    super(Type.SceneCollectionListChanged, Intent.Config);
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
