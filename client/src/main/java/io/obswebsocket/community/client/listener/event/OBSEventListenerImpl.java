package io.obswebsocket.community.client.listener.event;

import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.Event.Intent;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class OBSEventListenerImpl implements OBSEventListener {

  private final ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();

  public OBSEventListenerImpl(
          ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners) {
    if (eventListeners != null) {
      this.eventListeners.putAll(eventListeners);
    }
  }

  @Override
  public void onEvent(Event event) {
    if (this.eventListeners.containsKey(event.getClass())) {
      this.eventListeners.get(event.getClass()).accept(event);
    }
  }

  /**
   * Internal way of computing the eventSubscription
   *
   * @return int eventSubscription value according to registered {@link Event} listeners
   */
  @Override
  public int computeEventSubscription() {
    return this.eventListeners.keySet().stream().map(aClass -> {
      Intent intent = Intent.None;
      try {
        Constructor<? extends Event> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Event<?> instance = constructor.newInstance();
        intent = instance.getMessageData().getEventIntent();
      } catch (Throwable t) {
        t.printStackTrace();
      }
      return intent;
    }).mapToInt(Intent::getValue).reduce(Intent.None.getValue(), (a, b) -> a | b);
  }
}
