package io.obswebsocket.community.client.message.response;

import io.obswebsocket.community.client.message.AbstractSerializationTest;

public class AbstractResponseSerializationTest extends AbstractSerializationTest {

  protected <T extends RequestResponse<?>> void assertResponse(String type,
      Class<T> responseClass) {
    String jsonFilename = responseClass.getSimpleName();
    String json = this.readResourceFile("responses/" + type + "/" + jsonFilename + ".json");

    T response = deserialize(json, responseClass);

    assertSerializationAndDeserialization(json, response);
  }
}
