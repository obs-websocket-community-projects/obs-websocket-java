package io.obswebsocket.community.client.message.event.inputs;

import io.obswebsocket.community.client.message.event.AbstractEventListenerTest;
import org.junit.jupiter.api.Test;

public class InputsEventsListenerTest extends AbstractEventListenerTest {

  @Test
  void inputCreatedEvent() {
    verifyEventListener(new InputCreatedEvent());
  }

  @Test
  void inputRemovedEvent() {
    verifyEventListener(new InputRemovedEvent());
  }

  @Test
  void inputNameChangedEvent() {
    verifyEventListener(new InputNameChangedEvent());
  }
}
