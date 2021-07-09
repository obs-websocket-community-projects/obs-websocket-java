package io.obswebsocket.community.client.listener.event;

import io.obswebsocket.community.client.message.event.Event;

public interface OBSEventListener {

  void onEvent(Event event);

  int computeEventSubscription();

}
