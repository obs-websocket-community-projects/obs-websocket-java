package io.obswebsocket.community.listener.event;

import io.obswebsocket.community.message.event.Event;

public interface ObsEventListener {

  void onEvent(Event event);

  int computeEventSubscription();

}
