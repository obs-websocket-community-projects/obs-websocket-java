package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemCreated extends SceneItemSource {
    protected SceneItemCreated() {
        super(Type.SceneItemCreated, Category.SceneItems);
    }
}
