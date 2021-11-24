package io.obswebsocket.community.client.message.event.transitions;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransitionStartedEvent extends TransitionEvent {

  @SerializedName("d")
  private Data messageData;

  protected TransitionStartedEvent() {
    super(Type.TransitionStarted, Intent.Transitions);
  }
}
