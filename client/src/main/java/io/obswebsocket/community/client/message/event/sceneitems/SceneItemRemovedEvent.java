package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemRemovedEvent extends SceneItemSourceEvent<SceneItemSourceEvent.SpecificData> {

  protected SceneItemRemovedEvent() {
    super(Intent.SceneItems);
  }

  protected SceneItemRemovedEvent(SpecificData data) {
    super(Intent.SceneItems, data);
  }
}
