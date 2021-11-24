package io.obswebsocket.community.client.message.event.sceneitems;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemListReindexedEvent extends SceneItemEvent {

  @SerializedName("d")
  private Data messageData;

  protected SceneItemListReindexedEvent() {
    super(Type.SceneItemListReindexed, Intent.SceneItems);
  }

  @Getter
  @ToString(callSuper = true)
  public static class SpecificData extends SceneItemEvent.SpecificData {

    private List<SceneItem> sceneItems;

    @Getter
    @ToString
    public static class SceneItem {

      private Integer sceneItemId;
      private Integer sceneItemIndex;
    }
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends SceneItemEvent.Data {

    protected SpecificData eventData;
  }
}
