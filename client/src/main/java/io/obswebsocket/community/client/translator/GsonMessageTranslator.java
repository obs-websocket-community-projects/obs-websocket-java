package io.obswebsocket.community.client.translator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.Message.OperationCode;
import io.obswebsocket.community.client.message.MessageSerialization;
import io.obswebsocket.community.client.message.OperationCodeSerialization;
import io.obswebsocket.community.client.message.event.Event;
import io.obswebsocket.community.client.message.event.EventIntentSerialization;
import io.obswebsocket.community.client.message.event.EventSerialization;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestSerialization;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.RequestResponseSerialization;
import java.lang.reflect.Type;

public class GsonMessageTranslator implements MessageTranslator {

  private final Gson gson;

  public GsonMessageTranslator() {
    this.gson = new GsonBuilder()
        .registerTypeAdapter(OperationCode.class, new OperationCodeSerialization())
        .registerTypeAdapter(Message.class, new MessageSerialization())
        .registerTypeAdapter(Event.class, new EventSerialization())
        .registerTypeAdapter(Event.Intent.class, new EventIntentSerialization())
        .registerTypeAdapter(Request.class, new RequestSerialization())
        .registerTypeAdapter(RequestResponse.class, new RequestResponseSerialization())
        .create();
  }

  @Override
  public <T> T fromJson(String json, Type clazz) {
    return gson.fromJson(json, clazz);
  }

  @Override
  public String toJson(Object object) {
    return gson.toJson(object);
  }
}
