package io.obswebsocket.community.client.message.event.sceneitems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemCreatedEvent extends SceneItemSourceEvent {

  @SerializedName("d")
  private Data messageData;

  protected SceneItemCreatedEvent() {
    super(Type.SceneItemCreated, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneItemEvent.Data {

    protected SceneItemEvent.SpecificData eventData;
  }
}
