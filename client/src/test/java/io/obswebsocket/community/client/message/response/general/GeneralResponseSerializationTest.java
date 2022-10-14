package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

class GeneralResponseSerializationTest extends AbstractSerializationTest {

  @Test
  void getVersionResponse() {

    String json = this.readResourceFile("responses/general/GetVersionResponse.json");

    GetVersionResponse response = deserialize(json, GetVersionResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void getStatsResponse() {

    String json = this.readResourceFile("responses/general/GetStatsResponse.json");

    GetStatsResponse response = deserialize(json, GetStatsResponse.class);

    assertSerializationAndDeserialization(json, response);
  }
}
