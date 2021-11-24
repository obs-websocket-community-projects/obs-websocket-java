package io.obswebsocket.community.client.message.event.transitions;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TransitionEndedEvent extends TransitionEvent {

  @SerializedName("d")
  private Data messageData;

  protected TransitionEndedEvent() {
    super(Type.TransitionEnded, Intent.Transitions);
  }

  @Getter
  @ToString(callSuper = true)
  public static class Data extends TransitionEvent.Data {

    protected TransitionEvent.SpecificData eventData;
  }
}
