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
    Hello obj = new Hello();
    obj.setWebsocketVersion("5.0.0");
    obj.setRpcVersion(1);
    Authentication authentication = new Authentication();
    authentication.setChallenge("+IxH4CnCiqpX1rM9scsNynZzbOe4KhDeYcTNS3PDaeY=");
    authentication.setSalt("lM1GncleQOaCu9lT1yeUZhFYnqhsLLP1G5lAGo3ixaI=");
    obj.setAuthentication(authentication);

    assertThat(gson.fromJson(json, Hello.class)).usingRecursiveComparison().isEqualTo(obj);
    JSONAssert.assertEquals(json, gson.toJson(obj),false);
  }

}
