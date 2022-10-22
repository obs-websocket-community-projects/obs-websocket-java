package io.obswebsocket.community.client.message.event;

import io.obswebsocket.community.client.message.AbstractSerializationTest;

public class AbstractEventSerializationTest extends AbstractSerializationTest {

  protected <D, T extends Event<D>> void assertEventType(String type, T eventInstance) {
    String className = eventInstance.getClass().getSimpleName();
    String classWithoutEvent = className.substring(0, className.length() - 5);

    String json = this.readResourceFile("events/" + type + "/" + classWithoutEvent + ".json");

    assertSerializationAndDeserialization(json, eventInstance);
  }
}
