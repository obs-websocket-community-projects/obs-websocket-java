package io.obswebsocket.community.client.message.event.transitions;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class TransitionNameChangedEvent extends TransitionEvent {

  @SerializedName("d")
  private Data messageData;

  protected TransitionNameChangedEvent() {
    super(Type.TransitionNameChanged, Intent.Transitions);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class SpecificData extends TransitionEvent.SpecificData {

    private String oldTransitionName; // TODO TransitionNameChangedEvent.Data
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends TransitionEvent.Data {

    protected SpecificData eventData;
  }
}
