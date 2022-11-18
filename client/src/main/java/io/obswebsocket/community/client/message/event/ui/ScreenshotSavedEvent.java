// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.ui;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * A screenshot has been saved.
 *
 * Note: Triggered for the screenshot feature available in `Settings -&gt; Hotkeys -&gt; Screenshot Output` ONLY.
 * Applications using `Get/SaveSourceScreenshot` should implement a `CustomEvent` if this kind of inter-client
 * communication is desired.
 */
@Getter
@ToString(
    callSuper = true
)
public class ScreenshotSavedEvent extends Event<ScreenshotSavedEvent.SpecificData> {
  protected ScreenshotSavedEvent() {
    super(Intent.Ui);
  }

  protected ScreenshotSavedEvent(ScreenshotSavedEvent.SpecificData data) {
    super(Intent.Ui, data);
  }

  /**
   * Path of the saved image file
   *
   * @return the savedScreenshotPath
   */
  public String getSavedScreenshotPath() {
    return getMessageData().getEventData().getSavedScreenshotPath();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Path of the saved image file
     */
    private String savedScreenshotPath;
  }
}
