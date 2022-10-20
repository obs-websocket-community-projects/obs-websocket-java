// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.general;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

/**
 * OBS has begun the shutdown process.
 */
@Getter
@ToString(
    callSuper = true
)
public class ExitStartedEvent extends Event<Void> {
  protected ExitStartedEvent() {
    super(Intent.General);
  }
}
