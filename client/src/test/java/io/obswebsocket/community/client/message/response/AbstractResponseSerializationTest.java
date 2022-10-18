package io.obswebsocket.community.client.message.response;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import java.util.function.Consumer;

public class AbstractResponseSerializationTest extends AbstractSerializationTest {

  protected <D, T extends RequestResponse<D>> void assertResponse(String type,
      Class<T> responseClass, Consumer<D> assertData) { // TODO: Does not check Request.Type.XXXX
    String jsonFilename = responseClass.getSimpleName();
    String json = this.readResourceFile("responses/" + type + "/" + jsonFilename + ".json");

    T response = deserialize(json, responseClass);

    assertSerializationAndDeserialization(json, response);
    assertData.accept(response.getMessageData().getResponseData());
  }
}
