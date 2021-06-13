package net.twasi.obsremotejava.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemCreatedEvent extends SceneItemSourceEvent {
    protected SceneItemCreatedEvent() {
        super(Type.SceneItemCreated, Category.SceneItems);
    }
}
