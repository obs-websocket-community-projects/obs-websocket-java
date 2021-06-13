package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneRemoved extends SceneChanged {
    protected SceneRemoved() {
        super(Type.SceneRemoved, Category.Scenes);
    }
}
