package io.obswebsocket.community.client.message.event.mediainputs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.event.OBSEventListenerImpl;
import io.obswebsocket.community.client.message.event.Event;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class MediaInputsEventsListenerTest {

  @Test
  void mediaInputActionTriggeredEventTriggered() {
    // given an EventListener registered to listen to a MediaInputActionTriggeredEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(MediaInputActionTriggeredEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    MediaInputActionTriggeredEvent event = new MediaInputActionTriggeredEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }

  @Test
  void mediaInputPlaybackStartedEventTriggered() {
    // given an EventListener registered to listen to a MediaInputPlaybackEndedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(MediaInputPlaybackStartedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    MediaInputPlaybackStartedEvent event = new MediaInputPlaybackStartedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }

  @Test
  void mediaInputPlaybackEndedEventTriggered() {
    // given an EventListener registered to listen to a MediaInputPlaybackEndedEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(MediaInputPlaybackEndedEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    MediaInputPlaybackEndedEvent event = new MediaInputPlaybackEndedEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);
  }
}
