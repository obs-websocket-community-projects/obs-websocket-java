// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.ui;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Studio mode has been enabled or disabled.
 */
@Getter
@ToString(
    callSuper = true
)
public class StudioModeStateChangedEvent extends Event<StudioModeStateChangedEvent.SpecificData> {
  protected StudioModeStateChangedEvent() {
    super(Intent.Ui);
  }

  protected StudioModeStateChangedEvent(StudioModeStateChangedEvent.SpecificData data) {
    super(Intent.Ui, data);
  }

  /**
   * True == Enabled, False == Disabled
   *
   * @return the studioModeEnabled
   */
  public Boolean getStudioModeEnabled() {
    return getMessageData().getEventData().getStudioModeEnabled();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * True == Enabled, False == Disabled
     */
    private Boolean studioModeEnabled;
  }
}
