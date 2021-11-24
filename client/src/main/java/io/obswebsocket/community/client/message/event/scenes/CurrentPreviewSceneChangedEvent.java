package io.obswebsocket.community.client.message.event.scenes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentPreviewSceneChangedEvent extends SceneEvent {

  @SerializedName("d")
  private Data messageData;

  protected CurrentPreviewSceneChangedEvent() {
    super(Type.CurrentPreviewSceneChanged, Intent.Scenes);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneEvent.Data {

    protected SceneEvent.SpecificData eventData;
  }
}
