package net.twasi.obsremotejava.translator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.twasi.obsremotejava.message.Message;
import net.twasi.obsremotejava.message.MessageSerialization;
import net.twasi.obsremotejava.message.event.Event;
import net.twasi.obsremotejava.message.event.EventSerialization;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestSerialization;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.message.response.RequestResponseSerialization;

public class GsonMessageTranslator implements MessageTranslator {

  private final Gson gson;

  public GsonMessageTranslator() {
    this.gson = new GsonBuilder()
      .registerTypeAdapter(Message.class, new MessageSerialization())
      .registerTypeAdapter(Event.class, new EventSerialization())
      .registerTypeAdapter(Request.class, new RequestSerialization())
      .registerTypeAdapter(RequestResponse.class, new RequestResponseSerialization())
      .create();
  }

  @Override
  public <T> T fromJson(String json, Class<T> clazz) {
    return gson.fromJson(json, clazz);
  }

  @Override
  public String toJson(Object object) {
    return gson.toJson(object);
  }
}
