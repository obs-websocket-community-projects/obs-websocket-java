package io.obswebsocket.community.client.message.event.vendors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.obswebsocket.community.client.listener.event.OBSEventListener;
import io.obswebsocket.community.client.listener.event.OBSEventListenerImpl;
import io.obswebsocket.community.client.message.event.Event;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class VendorsEventsListenerTest {

  @Test
  void vendorEventTriggered() {

    // given an EventListener registered to listen to a CustomEvent
    Consumer consumer = mock(Consumer.class);
    ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();
    eventListeners.put(VendorEvent.class, consumer);
    OBSEventListener eventListener = new OBSEventListenerImpl(eventListeners);

    // When triggered
    VendorEvent event = new VendorEvent();
    eventListener.onEvent(event);

    // Then the event listener will be called
    verify(consumer).accept(event);

  }

}
