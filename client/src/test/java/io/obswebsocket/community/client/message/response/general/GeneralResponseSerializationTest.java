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

  @Test
  void broadcastCustomEventResponse() {

    String json = this.readResourceFile("responses/general/BroadcastCustomEventResponse.json");

    BroadcastCustomEventResponse response = deserialize(json, BroadcastCustomEventResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void callVendorRequestResponse() {

    String json = this.readResourceFile("responses/general/CallVendorRequestResponse.json");

    CallVendorRequestResponse response = deserialize(json, CallVendorRequestResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void getHotkeyListResponse() {

    String json = this.readResourceFile("responses/general/GetHotkeyListResponse.json");

    GetHotkeyListResponse response = deserialize(json, GetHotkeyListResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void triggerHotkeyByNameResponse() {

    String json = this.readResourceFile("responses/general/TriggerHotkeyByNameResponse.json");

    TriggerHotkeyByNameResponse response = deserialize(json, TriggerHotkeyByNameResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void triggerHotkeyByKeySequenceResponse() {

    String json = this.readResourceFile("responses/general/TriggerHotkeyByKeySequenceResponse.json");

    TriggerHotkeyByKeySequenceResponse response = deserialize(json, TriggerHotkeyByKeySequenceResponse.class);

    assertSerializationAndDeserialization(json, response);
  }

  @Test
  void sleepResponse() {

    String json = this.readResourceFile("responses/general/SleepResponse.json");

    SleepResponse response = deserialize(json, SleepResponse.class);

    assertSerializationAndDeserialization(json, response);
  }
}
