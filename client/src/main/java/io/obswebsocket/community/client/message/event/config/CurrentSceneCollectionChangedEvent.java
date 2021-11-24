package io.obswebsocket.community.client.message.event.config;

import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneCollectionChangedEvent extends Event {

  @SerializedName("d")
  private Data messageData;

  protected CurrentSceneCollectionChangedEvent() {
    super(Type.CurrentSceneCollectionChanged, Intent.Config);
  }

  @Getter
  @ToString
  public static class SpecificData {

    private String currentSceneCollectionName;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends Event.Data {

    protected SpecificData eventData;
  }
}
