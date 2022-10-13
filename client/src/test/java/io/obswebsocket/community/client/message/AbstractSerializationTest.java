package io.obswebsocket.community.client.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public abstract class AbstractSerializationTest {

  MessageTranslator translator = new GsonMessageTranslator();

  protected void assertSerializationAndDeserialization(String json, Object obj) {
    assertSerializationAndDeserialization(json, obj, false);
  }

  protected void assertSerializationAndDeserialization(String json, Object obj, boolean strict) {
    assertDeserialization(json, obj);
    assertSerialization(json, obj, strict);
  }

  protected void assertDeserialization(String json, Object obj) {
    Object actualObject = deserialize(json, obj.getClass());
    System.out.println("Deserialized to: " + actualObject);
    assertThat(actualObject).usingRecursiveComparison().isEqualTo(obj);
  }

  protected <T> T deserialize(String json, Type clazz) {
    return translator.fromJson(json, clazz);
  }

  protected void assertSerialization(String json, Object obj, boolean strict) {
    try {
      String actualJson = translator.toJson(obj);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, strict);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }

  protected <T> T deserializeTo(String json, Class<T> clazz) {
    return translator.fromJson(json, clazz);
  }

  protected boolean isDeserializable(String json) {
    try {
      Object obj = deserializeTo(json, Object.class);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
