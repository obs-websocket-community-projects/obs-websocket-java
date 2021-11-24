package io.obswebsocket.community.client.message.event.transitions;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class TransitionStartedEvent extends TransitionEvent {

  @SerializedName("d")
  private Data messageData;

  protected TransitionStartedEvent() {
    super(Type.TransitionStarted, Intent.Transitions);
  }

  protected TransitionStartedEvent(String transitionName) {
    this();
    this.messageData = Data.builder()
        .eventType(Type.TransitionStarted)
        .eventIntent(Intent.Transitions)
        .eventData(SpecificData.builder().transitionName(transitionName).build())
        .build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data extends TransitionEvent.Data {

    protected TransitionEvent.SpecificData eventData;
  }
}
