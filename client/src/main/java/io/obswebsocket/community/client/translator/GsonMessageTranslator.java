package io.obswebsocket.community.client.translator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class GsonMessageTranslator implements MessageTranslator {

  private final Gson gson;

  public GsonMessageTranslator() {
    this.gson = new GsonBuilder()
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
