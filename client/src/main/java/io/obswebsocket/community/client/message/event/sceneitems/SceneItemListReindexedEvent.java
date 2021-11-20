package io.obswebsocket.community.client.message.event.sceneitems;

import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemListReindexedEvent extends SceneItemEvent {

  private Data eventData;

  protected SceneItemListReindexedEvent() {
    super(Type.SceneItemListReindexed, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends SceneItemEvent.Data {

    private List<SceneItem> sceneItems;

    @Getter
    @ToString
    public static class SceneItem {

      private Integer sceneItemId;
      private Integer sceneItemIndex;
    }
  }
}
