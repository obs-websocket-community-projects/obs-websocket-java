package io.obswebsocket.community.client.message.event.sceneitems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemLockStateChangedEvent extends SceneItemEvent {

  @SerializedName("d")
  private Data messageData;

  protected SceneItemLockStateChangedEvent() {
    super(Type.SceneItemLockStateChanged, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private Integer sceneItemId;
    private Boolean sceneItemLocked;
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneItemEvent.Data {

    protected SpecificData eventData;
  }
}
