package io.obswebsocket.community.client.message.request.general;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.ui.GetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.request.ui.SetStudioModeEnabledRequest;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class GeneralRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getVersionRequest() {
    GetVersionRequest getVersionRequest = GetVersionRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getVersionRequest.getRequestId());
    String json = this.readResourceFile("requests/general/GetVersion.json", vars);

    assertSerializationAndDeserialization(json, getVersionRequest);
  }

  @Test
  void getStatsRequest() {
    GetStatsRequest getStatsRequest = GetStatsRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getStatsRequest.getRequestId());
    String json = this.readResourceFile("requests/general/GetStats.json", vars);

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
    String json = this.readResourceFile("requests/general/BroadcastCustomEvent.json", vars);

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

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'vendorName': 'Vendor',\n" +
        "\t\t'requestType': 'Vendor Request type',\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'testKey': 'Test Value'\n" +
        "\t\t}\n" +
        "\t},\n" +
        "\t'requestType': 'CallVendorRequest',\n" +
        "\t'requestId': " + callVendorRequestRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, callVendorRequestRequest);
  }

  @Test
  void getHotkeyListRequest() {
    GetHotkeyListRequest getHotkeyListRequest = GetHotkeyListRequest.builder().build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetHotkeyList',\n" +
        "\t'requestId': " + getHotkeyListRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getHotkeyListRequest);
  }

  @Test
  void getStudioModeEnabledRequest() {
    GetStudioModeEnabledRequest getStudioModeEnabledRequest = GetStudioModeEnabledRequest.builder()
        .build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetStudioModeEnabled',\n" +
        "\t'requestId': " + getStudioModeEnabledRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}\n";

    assertSerializationAndDeserialization(json, getStudioModeEnabledRequest);
  }

  @Test
  void setStudioModeEnabledRequest() {
    SetStudioModeEnabledRequest setStudioModeEnabledRequest = SetStudioModeEnabledRequest.builder()
        .studioModeEnabled(false).build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'studioModeEnabled': false\n" +
        "\t},\n" +
        "\t'requestType': 'SetStudioModeEnabled',\n" +
        "\t'requestId': " + setStudioModeEnabledRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setStudioModeEnabledRequest);
  }

  @Test
  void sleepRequest() {
    SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000).sleepFrames(5).build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sleepMillis': 1000,\n" +
        "\t\t'sleepMillis': 5\n" +
        "\t},\n" +
        "\t'requestType': 'Sleep',\n" +
        "\t'requestId': " + sleepRequest1000.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    Request request = deserializeTo(json, Request.class);
    assertThat(request).isNotNull();
    assertThat(request.getRequestType()).isEqualTo(Request.Data.Type.Sleep);
  }

  @Test
  void triggerHotkeyByNameRequest() {
    TriggerHotkeyByNameRequest triggerHotkeyByNameRequest = TriggerHotkeyByNameRequest.builder()
        .hotkeyName("Hotkey").build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'hotkeyName': 'Hotkey'\n" +
        "\t},\n" +
        "\t'requestType': 'TriggerHotkeyByName',\n" +
        "\t'requestId': " + triggerHotkeyByNameRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

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

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'keyId': 'KeyId1',\n" +
        "\t\t'keyModifiers': {\n" +
        "\t\t\t'shift': true,\n" +
        "\t\t\t'alt': true,\n" +
        "\t\t\t'control': false,\n" +
        "\t\t\t'command': false\n" +
        "\t\t}\n" +
        "\t},\n" +
        "\t'requestType': 'TriggerHotkeyByName',\n" +
        "\t'requestId': " + triggerHotkeyByKeySequenceRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, triggerHotkeyByKeySequenceRequest);
  }
}
