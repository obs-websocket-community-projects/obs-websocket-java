package io.obswebsocket.community.client.test.translator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import io.obswebsocket.community.client.translator.MessageTranslator;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public abstract class AbstractSerializationTest {

  MessageTranslator translator = new GsonMessageTranslator();

  protected void assertSerializationAndDeserialization(String json, Object obj) {
    assertSerializationAndDeserialization(json, obj, false);
  }

  protected void assertSerializationAndDeserialization(String json, Object obj, boolean strict) {
    Object actualObject = translator.fromJson(json, obj.getClass());
    System.out.println("Deserialized to: " + actualObject);
    assertThat(actualObject).usingRecursiveComparison().isEqualTo(obj);
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
