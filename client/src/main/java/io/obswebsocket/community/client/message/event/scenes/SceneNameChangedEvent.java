package io.obswebsocket.community.client.message.event.scenes;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneNameChangedEvent extends SceneEvent {

  @SerializedName("d")
  private Data messageData;

  protected SceneNameChangedEvent() {
    super(Type.SceneNameChanged, Intent.Scenes);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneEvent.SpecificData {

    private String oldSceneName;
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneEvent.Data {

    protected SpecificData eventData;
  }
}
