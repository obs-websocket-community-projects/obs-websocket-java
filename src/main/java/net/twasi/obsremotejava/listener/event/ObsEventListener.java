package net.twasi.obsremotejava.listener.event;

import net.twasi.obsremotejava.message.event.Event;

public interface ObsEventListener {

  void onEvent(Event event);

}
