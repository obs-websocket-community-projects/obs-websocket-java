package io.obswebsocket.community.client.message.event.transitions;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class CurrentTransitionChangedEvent extends TransitionEvent {

  @SerializedName("d")
  private Data messageData;

  protected CurrentTransitionChangedEvent() {
    super(Type.CurrentTransitionChanged, Intent.Transitions);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends TransitionEvent.Data {

    protected TransitionEvent.SpecificData eventData;
  }
}
