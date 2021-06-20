package net.twasi.obsremotejava.test.listeners.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import net.twasi.obsremotejava.listener.event.ObsEventListener;
import net.twasi.obsremotejava.listener.event.ObsEventListenerImpl;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.general.CustomEvent;
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
