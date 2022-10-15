package io.obswebsocket.community.client.message.event.sceneitems;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SceneItemListReindexedEvent extends
    SceneItemEvent<SceneItemListReindexedEvent.SpecificData> {

  protected SceneItemListReindexedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemListReindexedEvent(SpecificData data) {
    super(Intent.SceneItems, data);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends SceneItemEvent.SpecificData {

    @Singular
    private List<SceneItem> sceneItems;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    @ToString
    public static class SceneItem { // TODO: Are these not io.obswebsocket.community.client.model.SceneItem ?

      private Integer sceneItemId;
      private Integer sceneItemIndex;
    }
  }
}
