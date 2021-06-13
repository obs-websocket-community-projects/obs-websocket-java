package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemRemoved extends SceneItemSource {
    protected SceneItemRemoved() {
        super(Type.SceneItemRemoved, Category.SceneItems);
    }
}
