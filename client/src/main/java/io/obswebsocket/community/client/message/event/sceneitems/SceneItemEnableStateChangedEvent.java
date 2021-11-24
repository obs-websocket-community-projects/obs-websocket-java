package io.obswebsocket.community.client.message.event.sceneitems;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemEnableStateChangedEvent extends SceneItemEvent {

  @SerializedName("d")
  private Data messageData;

  protected SceneItemEnableStateChangedEvent() {
    super(Type.SceneItemEnableStateChanged, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private Integer sceneItemId;
    private Boolean sceneItemEnabled;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneItemEvent.Data {

    protected SpecificData eventData;
  }
}
