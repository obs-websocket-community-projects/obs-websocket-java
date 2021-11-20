package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemLockStateChangedEvent extends SceneItemEvent {

  private Data eventData;

  protected SceneItemLockStateChangedEvent() {
    super(Type.SceneItemLockStateChanged, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneItemEvent.Data {

    private Integer sceneItemId;
    private Boolean sceneItemLocked;
  }
}
