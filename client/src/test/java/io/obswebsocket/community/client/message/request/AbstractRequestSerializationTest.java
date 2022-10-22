package io.obswebsocket.community.client.message.request;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import java.util.HashMap;

public class AbstractRequestSerializationTest extends AbstractSerializationTest {

  protected <T> void assertRequest(String type, Request<T> request) {
    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", request.getRequestId());

    String jsonFilename = request.getClass().getSimpleName();
    String json = this.readResourceFile("requests/" + type + "/" + jsonFilename + ".json", vars);

    assertSerializationAndDeserialization(json, request);
  }
}
