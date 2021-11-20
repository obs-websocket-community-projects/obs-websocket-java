package io.obswebsocket.community.client.message.event.sceneitems;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SceneItemRemovedEvent extends SceneItemSourceEvent {

  protected SceneItemRemovedEvent() {
    super(Type.SceneItemRemoved, Intent.SceneItems);
  }
}
