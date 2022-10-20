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

  @Test
  void replayBufferStateChangedEventTriggered() {
    // given an EventListener registered to listen to a ReplayBufferStateChangedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(ReplayBufferStateChangedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    ReplayBufferStateChangedEvent event = new ReplayBufferStateChangedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }

  @Test
  void virtualcamStateChangedEventTriggered() {
    // given an EventListener registered to listen to a VirtualcamStateChangedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(VirtualcamStateChangedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    VirtualcamStateChangedEvent event = new VirtualcamStateChangedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }

  @Test
  void replayBufferSavedEventTriggered() {
    // given an EventListener registered to listen to a ReplayBufferSavedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(ReplayBufferSavedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    ReplayBufferSavedEvent event = new ReplayBufferSavedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }
}
