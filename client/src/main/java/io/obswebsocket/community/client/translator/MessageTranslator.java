package io.obswebsocket.community.client.translator;

public interface MessageTranslator {

  <T> T fromJson(String json, Class<T> clazz);

  String toJson(Object object);
}
