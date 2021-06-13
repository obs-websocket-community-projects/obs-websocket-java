package net.twasi.obsremotejava.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import com.google.gson.Gson;
import net.twasi.obsremotejava.ObsCommunicatorBuilder;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Hello.Authentication;
import net.twasi.obsremotejava.message.authentication.Identified;
import net.twasi.obsremotejava.message.authentication.Identify;
import net.twasi.obsremotejava.message.authentication.Reidentify;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class AuthenticationSerializationTest {

  Gson gson = ObsCommunicatorBuilder.GSON();

  @Test
  void hello() {
    String json = "{\n"
      + "  \"messageType\": \"Hello\",\n"
      + "  \"obsWebSocketVersion\": \"5.0.0\",\n"
      + "  \"rpcVersion\": 1,\n"
      + "  \"authentication\": {\n"
      + "    \"challenge\": \"+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=\",\n"
      + "    \"salt\": \"lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=\"\n"
      + "  }\n"
      + "}";

    Hello obj = Hello.builder()
      .obsWebSocketVersion("5.0.0")
      .rpcVersion(1)
      .authentication(Authentication.builder()
        .challenge("+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=")
        .salt("lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=")
      .build())
      .build();

    assertSerializationAndDeserialization(json, obj);

  }

  @Test
  void identify() {
    String json = "{\n"
      + "  \"messageType\": \"Identify\",\n"
      + "  \"rpcVersion\": 1,\n"
      + "  \"authentication\": \"Dj6cLS+jrNA0HpCArRg0Z/Fc+YHdt2FQfAvgD1mip6Y=\",\n"
      + "  \"ignoreInvalidMessages\": true,\n"
      + "  \"ignoreNonFatalRequestChecks\": true,\n"
      + "  \"eventSubscriptions\": 33\n"
      + "}";

    Identify obj = Identify.builder()
      .rpcVersion(1)
      .authentication("Dj6cLS+jrNA0HpCArRg0Z/Fc+YHdt2FQfAvgD1mip6Y=")
      .ignoreInvalidMessages(true)
      .ignoreNonFatalRequestChecks(true)
      .eventSubscriptions(33)
      .build();

    assertSerializationAndDeserialization(json, obj);
  }

  @Test
  void identified() {
    String json = "{\n"
      + "  \"messageType\": \"Identified\",\n"
      + "  \"negotiatedRpcVersion\": 1"
      + "}";
    Identified obj = Identified.builder()
      .negotiatedRpcVersion(1)
      .build();

    assertSerializationAndDeserialization(json, obj);
  }

  @Test
  void reidentify() {
    String json = "{\n"
      + "  \"messageType\": \"Reidentify\",\n"
      + "  \"ignoreInvalidMessages\": true,\n"
      + "  \"ignoreNonFatalRequestChecks\": true,\n"
      + "  \"eventSubscriptions\": 33\n"
      + "}";
    Reidentify obj = Reidentify.builder()
      .ignoreInvalidMessages(true)
      .ignoreNonFatalRequestChecks(true)
      .eventSubscriptions(33)
      .build();

    assertSerializationAndDeserialization(json, obj);
  }

  private void assertSerializationAndDeserialization(String json, Object obj) {
    assertSerializationAndDeserialization(json, obj, false);
  }

  private void assertSerializationAndDeserialization(String json, Object obj, boolean strict) {
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
