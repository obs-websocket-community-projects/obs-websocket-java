package net.twasi.obsremotejava.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import net.twasi.obsremotejava.GsonConfig;
import net.twasi.obsremotejava.message.authentication.Hello;
import net.twasi.obsremotejava.message.authentication.Hello.Authentication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class SerializeDeserializeTest {

  Gson gson = new GsonConfig().getInstance();

  @Test
  void hello() throws JSONException {
    String json = "{\n"
      + "  \"messageType\": \"Hello\",\n"
      + "  \"websocketVersion\": \"5.0.0\",\n"
      + "  \"rpcVersion\": 1,\n"
      + "  \"authentication\": {\n"
      + "    \"challenge\": \"+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=\",\n"
      + "    \"salt\": \"lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=\"\n"
      + "  }\n"
      + "}";

    Hello obj = Hello.builder()
      .websocketVersion("5.0.0")
      .rpcVersion(1)
      .authentication(Authentication.builder()
        .challenge("+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=")
        .salt("lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=")
      .build())
      .build();

    assertThat(gson.fromJson(json, Hello.class)).usingRecursiveComparison().isEqualTo(obj);
    JSONAssert.assertEquals(json, gson.toJson(obj),false);
  }

}
