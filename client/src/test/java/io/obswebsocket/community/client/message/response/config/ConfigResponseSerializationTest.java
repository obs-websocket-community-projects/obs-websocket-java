package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class ConfigResponseSerializationTest extends AbstractSerializationTest {

  @Test
  void getPersistentDataResponse() {
    String json = this.readResourceFile("responses/config/GetPersistentDataResponse.json");

    GetPersistentDataResponse response = deserialize(json, GetPersistentDataResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void setPersistentDataResponse() {
    String json = this.readResourceFile("responses/config/SetPersistentDataResponse.json");

    SetPersistentDataResponse response = deserialize(json, SetPersistentDataResponse.class);

    assertSerializationAndDeserialization(json, response);
  }
}
