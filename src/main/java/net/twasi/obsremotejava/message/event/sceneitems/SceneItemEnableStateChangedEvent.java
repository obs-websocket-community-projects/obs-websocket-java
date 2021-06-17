package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class SceneItemEnableStateChangedEvent extends SceneItemEvent {
    private Data eventData;

    protected SceneItemEnableStateChangedEvent() {
        super(Type.SceneItemEnableStateChanged, Category.SceneItems);
    }

    @Getter
    @ToString(callSuper = true)
    public static class Data extends SceneItemEvent.Data {
        private String sceneItemId;
        private Boolean sceneItemEnabled;
    }
}
