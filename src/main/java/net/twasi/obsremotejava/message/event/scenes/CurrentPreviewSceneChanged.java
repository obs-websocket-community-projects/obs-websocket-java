package net.twasi.obsremotejava.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentPreviewSceneChanged extends SceneChanged {
    protected CurrentPreviewSceneChanged() {
        super(Type.CurrentPreviewSceneChanged, Category.Scenes);
    }
}
