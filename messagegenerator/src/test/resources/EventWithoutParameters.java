// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event.category;

import io.obswebsocket.community.client.message.event.Event;
import lombok.Getter;
import lombok.ToString;

/**
 * Description
 */
@Getter
@ToString(
    callSuper = true
)
public class TypeEvent extends Event<Void> {
  protected TypeEvent() {
    super(Intent.subscription);
  }
}
