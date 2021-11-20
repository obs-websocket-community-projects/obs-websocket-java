package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemEnableStateChangedEvent extends SceneItemEvent {

  private Data eventData;

  protected SceneItemEnableStateChangedEvent() {
    super(Type.SceneItemEnableStateChanged, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneItemEvent.Data {

    private Integer sceneItemId;
    private Boolean sceneItemEnabled;
  }
}
