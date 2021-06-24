package io.obswebsocket.community.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneItemListReindexedEvent extends SceneItemEvent {
    private Data eventData;

    protected SceneItemListReindexedEvent() {
        super(Type.SceneItemListReindexed, Category.SceneItems);
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
