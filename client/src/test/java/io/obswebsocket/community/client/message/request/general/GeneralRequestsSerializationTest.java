package io.obswebsocket.community.client.message.request.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.AbstractSerializationTest;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class GeneralRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getVersionRequest() {
    GetVersionRequest getVersionRequest = GetVersionRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getVersionRequest.getRequestId());
    String json = this.readResourceFile("requests/general/GetVersionRequest.json", vars);

    assertSerializationAndDeserialization(json, getVersionRequest);
  }

  @Test
  void getStatsRequest() {
    GetStatsRequest getStatsRequest = GetStatsRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getStatsRequest.getRequestId());
    String json = this.readResourceFile("requests/general/GetStatsRequest.json", vars);

    assertSerializationAndDeserialization(json, getStatsRequest);
  }

  @Test
  void broadcastCustomEventRequest() {
    JsonObject eventData = new JsonObject();
    eventData.addProperty("customEventType", "customEvent");
    eventData.addProperty("boolean", true);

    BroadcastCustomEventRequest broadcastCustomEventRequest = BroadcastCustomEventRequest.builder()
        .eventData(eventData).build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", broadcastCustomEventRequest.getRequestId());
    String json = this.readResourceFile("requests/general/BroadcastCustomEventRequest.json", vars);

    assertSerializationAndDeserialization(json, broadcastCustomEventRequest);
  }

  @Test
  void callVendorRequestRequest() {
    JsonObject requestData = new JsonObject();
    requestData.addProperty("testKey", "Test Value");

    CallVendorRequestRequest callVendorRequestRequest = CallVendorRequestRequest.builder()
        .vendorName("Vendor")
        .requestType("Vendor Request type")
        .requestData(requestData)
        .build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", callVendorRequestRequest.getRequestId());
    String json = this.readResourceFile("requests/general/CallVendorRequestRequest.json", vars);

    assertSerializationAndDeserialization(json, callVendorRequestRequest);
  }

  @Test
  void getHotkeyListRequest() {
    GetHotkeyListRequest getHotkeyListRequest = GetHotkeyListRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getHotkeyListRequest.getRequestId());
    String json = this.readResourceFile("requests/general/GetHotkeyListRequest.json", vars);

    assertSerializationAndDeserialization(json, getHotkeyListRequest);
  }

  @Test
  void sleepRequest() {
    SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000).sleepFrames(5).build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", sleepRequest1000.getRequestId());
    String json = this.readResourceFile("requests/general/SleepRequest.json", vars);

    assertSerializationAndDeserialization(json, sleepRequest1000);
  }

  @Test
  void triggerHotkeyByNameRequest() {
    TriggerHotkeyByNameRequest triggerHotkeyByNameRequest = TriggerHotkeyByNameRequest.builder()
        .hotkeyName("Hotkey").build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", triggerHotkeyByNameRequest.getRequestId());
    String json = this.readResourceFile("requests/general/TriggerHotkeyByNameRequest.json", vars);


    assertSerializationAndDeserialization(json, triggerHotkeyByNameRequest);
  }

  @Test
  void triggerHotkeyByKeySequenceRequest() {
    TriggerHotkeyByKeySequenceRequest triggerHotkeyByKeySequenceRequest = TriggerHotkeyByKeySequenceRequest
        .builder()
        .keyId("KeyId1")
        .keyModifiers(TriggerHotkeyByKeySequenceRequest.KeyModifiers.builder()
            .alt(true)
            .shift(true)
            .build()
        ).build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", triggerHotkeyByKeySequenceRequest.getRequestId());
    String json = this.readResourceFile("requests/general/TriggerHotkeyByKeySequenceRequest.json", vars);

    assertSerializationAndDeserialization(json, triggerHotkeyByKeySequenceRequest);
  }
}
