package net.twasi.obsremotejava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.MessageDeserializer;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.EventDeserializer;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestDeserializer;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.RequestResponseDeserializer;

public class GsonConfig {
  public Gson getInstance() {
    return new GsonBuilder()
      .registerTypeAdapter(Message.class, new MessageDeserializer())
      .registerTypeAdapter(Event.class, new EventDeserializer())
      .registerTypeAdapter(Request.class, new RequestDeserializer())
      .registerTypeAdapter(RequestResponse.class, new RequestResponseDeserializer())
      .create();
  }
}
