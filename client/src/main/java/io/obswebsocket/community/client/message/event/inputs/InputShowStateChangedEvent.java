package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * An input's show state has changed.
 *
 * When an input is showing, it means it's being shown by the preview or a dialog.
 *
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class InputShowStateChangedEvent extends Event<InputShowStateChangedEvent.SpecificData> {
  protected InputShowStateChangedEvent() {
    super(Intent.InputShowStateChanged);
  }

  protected InputShowStateChangedEvent(InputShowStateChangedEvent.SpecificData data) {
    super(Intent.InputShowStateChanged, data);
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Name of the input
     */
    @NonNull
    private String inputName;

    /**
     * Whether the input is showing
     */
    @NonNull
    private Boolean videoShowing;
  }
}
