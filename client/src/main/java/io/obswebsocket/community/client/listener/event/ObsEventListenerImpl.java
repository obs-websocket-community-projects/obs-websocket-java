package io.obswebsocket.community.client.listener.event;

import io.obswebsocket.community.client.message.event.Event;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class ObsEventListenerImpl implements ObsEventListener {

  private final ConcurrentHashMap<Class<? extends Event>, Consumer> eventListeners = new ConcurrentHashMap<>();

  public ObsEventListenerImpl(
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
      Event.Category category = Event.Category.None;
      try {
        Constructor<? extends Event> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Event instance = constructor.newInstance();
        category = instance.getCategory();
      } catch (Throwable t) {
        t.printStackTrace();
      }
      return category;
    }).mapToInt(Event.Category::getValue).reduce(Event.Category.None.getValue(), (a, b) -> a | b);
  }
}
