package io.obswebsocket.community.client.message.event;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.event.OBSEventListenerImpl;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class AbstractEventListenerTest {

  protected <T extends Event<?>> void verifyEventListener(T eventInstance) {
    // given an EventListener registered to listen to an eventInstance
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(eventInstance.getClass(), consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    try {
      eventListener.onEvent(eventInstance);

      // Then the event listener will be called
      verify(consumer).accept(eventInstance);
    } catch (Throwable t) {
      fail("Exception thrown", t);
    }
  }
}
