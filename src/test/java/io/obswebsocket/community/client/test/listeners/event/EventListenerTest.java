package io.obswebsocket.community.client.test.listeners.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.listener.event.ObsEventListener;
import io.obswebsocket.community.client.listener.event.ObsEventListenerImpl;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.general.CustomEvent;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class EventListenerTest {

  @Test
  void customEventTriggered() {

    // given an EventListener registered to listen to a CustomEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(CustomEvent.class, consumer);
    ObsEventListener eventListener = new ObsEventListenerImpl(eventListeners);

    // When triggered
    CustomEvent event = CustomEvent.builder()
        .eventData(new JsonObject())
        .build();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);

  }

}
