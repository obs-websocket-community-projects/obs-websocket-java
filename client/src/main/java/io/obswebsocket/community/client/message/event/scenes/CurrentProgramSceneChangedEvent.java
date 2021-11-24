package io.obswebsocket.community.client.message.event.scenes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CurrentProgramSceneChangedEvent extends SceneEvent {

  @SerializedName("d")
  private Data messageData;

  protected CurrentProgramSceneChangedEvent() {
    super(Type.CurrentProgramSceneChanged, Intent.Scenes);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneEvent.Data {

    protected SceneEvent.SpecificData eventData;
  }
}
