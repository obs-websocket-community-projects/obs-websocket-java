package io.obswebsocket.community.client.translator;

import java.lang.reflect.Type;

public interface MessageTranslator {

  <T> T fromJson(String json, Type clazz);

  String toJson(Object object);
}
