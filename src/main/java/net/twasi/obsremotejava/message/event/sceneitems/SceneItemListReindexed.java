package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneItemListReindexed extends SceneItem {
    private Data eventData;

    protected SceneItemListReindexed() {
        super(Type.SceneItemListReindexed, Category.SceneItems);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends SceneItem.Data {
        private List<SceneItem> sceneItems;

        @Getter
        @ToString
        public static class SceneItem {
            private String sceneItemId;
            private Integer sceneItemIndex;
        }
    }
}
