package io.obswebsocket.community.client.message.event.ui;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.event.OBSEventListenerImpl;
import io.obswebsocket.community.client.message.event.Event;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class UIEventsListenerTest {

  @Test
  void studioModeStateChangedEventTriggered() {
    // given an EventListener registered to listen to a StudioModeStateChangedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(StudioModeStateChangedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    StudioModeStateChangedEvent event = new StudioModeStateChangedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }
}
