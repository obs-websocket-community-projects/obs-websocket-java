// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.event;

import io.obswebsocket.community.client.message.event.category.TypeEvent;
import io.obswebsocket.community.client.message.event.other.OtherEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventType {
  Type(TypeEvent.class),

  Other(OtherEvent.class);

  private final Class<? extends Event> eventClass;

  static EventType from(Class<? extends Event> eventClass) {
    for (EventType type : values()) {
      if (type.eventClass.equals(eventClass)) {
        return type;
      }
    }
    return null;
  }
}
