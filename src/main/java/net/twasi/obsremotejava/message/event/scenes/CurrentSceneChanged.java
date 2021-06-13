package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentSceneChanged extends SceneChanged {
    protected CurrentSceneChanged() {
        super(Type.CurrentSceneChanged, Category.Scenes);
    }
}
