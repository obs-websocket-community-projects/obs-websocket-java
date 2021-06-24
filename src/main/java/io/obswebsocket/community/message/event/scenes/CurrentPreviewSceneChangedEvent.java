package io.obswebsocket.community.message.event.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CurrentPreviewSceneChangedEvent extends SceneChangedEvent {
    protected CurrentPreviewSceneChangedEvent() {
        super(Type.CurrentPreviewSceneChanged, Category.Scenes);
    }
}
