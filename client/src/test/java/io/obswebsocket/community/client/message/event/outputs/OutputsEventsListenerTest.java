package io.obswebsocket.community.client.message.event.outputs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.event.OBSEventListenerImpl;
import io.obswebsocket.community.client.message.event.Event;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class OutputsEventsListenerTest {

  @Test
  void streamStateChangedEventTriggered() {
    // given an EventListener registered to listen to a StreamStateChangedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(StreamStateChangedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    StreamStateChangedEvent event = new StreamStateChangedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }

  @Test
  void recordStateChangedEventTriggered() {
    // given an EventListener registered to listen to a RecordStateChangedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(RecordStateChangedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    RecordStateChangedEvent event = new RecordStateChangedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }
}
