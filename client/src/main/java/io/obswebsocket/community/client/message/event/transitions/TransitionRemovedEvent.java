package io.obswebsocket.community.client.message.event.transitions;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransitionRemovedEvent extends TransitionEvent {

  @SerializedName("d")
  private Data messageData;

  protected TransitionRemovedEvent() {
    super(Type.TransitionRemoved, Intent.Transitions);
  }
}
