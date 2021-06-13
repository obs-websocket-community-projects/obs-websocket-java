package net.twasi.obsremotejava.test.serialization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import com.google.gson.Gson;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

public class AbstractSerializationTest {

  Gson gson = ObsCommunicatorBuilder.GSON();

  protected void assertSerializationAndDeserialization(String json, Object obj) {
    assertSerializationAndDeserialization(json, obj, false);
  }

  protected void assertSerializationAndDeserialization(String json, Object obj, boolean strict) {
    Object actualObject = gson.fromJson(json, obj.getClass());
    System.out.println("Deserialized to: " + actualObject);
    assertThat(actualObject).usingRecursiveComparison().isEqualTo(obj);
    try {
      String actualJson = gson.toJson(obj);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, strict);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }
}
