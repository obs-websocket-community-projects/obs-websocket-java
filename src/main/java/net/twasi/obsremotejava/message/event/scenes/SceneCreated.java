package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneCreated extends SceneChanged {
    protected SceneCreated() {
        super(Type.SceneCreated, Category.Scenes);
    }
}
