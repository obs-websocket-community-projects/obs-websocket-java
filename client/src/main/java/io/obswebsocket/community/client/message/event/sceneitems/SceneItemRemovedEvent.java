package io.obswebsocket.community.client.message.event.sceneitems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemRemovedEvent extends SceneItemSourceEvent {

  @SerializedName("d")
  private Data messageData;

  protected SceneItemRemovedEvent() {
    super(Type.SceneItemRemoved, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneItemSourceEvent.Data {

    protected SceneItemSourceEvent.SpecificData eventData;
  }
}
