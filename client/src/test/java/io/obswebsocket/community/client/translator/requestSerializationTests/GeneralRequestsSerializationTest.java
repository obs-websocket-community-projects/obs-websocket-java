package io.obswebsocket.community.client.translator.requestSerializationTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.general.BroadcastCustomEventRequest;
import io.obswebsocket.community.client.message.request.general.CloseProjectorRequest;
import io.obswebsocket.community.client.message.request.general.GetHotkeyListRequest;
import io.obswebsocket.community.client.message.request.general.GetProjectorListRequest;
import io.obswebsocket.community.client.message.request.general.GetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.request.general.GetSystemStatsRequest;
import io.obswebsocket.community.client.message.request.general.GetVersionRequest;
import io.obswebsocket.community.client.message.request.general.OpenProjectorRequest;
import io.obswebsocket.community.client.message.request.general.SetStudioModeEnabledRequest;
import io.obswebsocket.community.client.message.request.general.SleepRequest;
import io.obswebsocket.community.client.message.request.general.TriggerHotkeyByKeySequenceRequest;
import io.obswebsocket.community.client.message.request.general.TriggerHotkeyByNameRequest;
import io.obswebsocket.community.client.model.Projector;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class GeneralRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getVersionRequest() {
    GetVersionRequest getVersionRequest = GetVersionRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetVersion\",\n" +
        "\t\"requestId\": " + getVersionRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getVersionRequest);
  }

  @Test
  void broadcastCustomEventRequest() {
    JsonObject eventData = new JsonObject();
    eventData.addProperty("customEventType", "customEvent");
    eventData.addProperty("boolean", true);
    eventData.addProperty("integer", 10);

    BroadcastCustomEventRequest broadcastCustomEventRequest = BroadcastCustomEventRequest.builder()
        .requestData(eventData).build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"customEventType\": \"customEvent\",\n" +
        "\t\t\"boolean\": true,\n" +
        "\t\t\"integer\": 10\n" +
        "\t},\n" +
        "\t\"requestType\": \"BroadcastCustomEvent\",\n" +
        "\t\"requestId\": " + broadcastCustomEventRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    MessageTranslator translator = new GsonMessageTranslator();

    BroadcastCustomEventRequest actualObject = translator
        .fromJson(json, BroadcastCustomEventRequest.class);
    assertThat(actualObject.getRequestData().get("customEventType").getAsString())
        .isEqualTo("customEvent");
    assertThat(actualObject.getRequestData().get("boolean").getAsBoolean()).isEqualTo(true);
    assertThat(actualObject.getRequestData().get("integer").getAsInt()).isEqualTo(10);
    Assertions.assertThat(actualObject.getRequestId())
        .isEqualTo(broadcastCustomEventRequest.getRequestId());
    Assertions.assertThat(actualObject.getRequestType())
        .isEqualTo(Request.Type.BroadcastCustomEvent);
    assertThat(actualObject.getMessageType()).isEqualTo(Message.Type.Request);
    try {
      String actualJson = translator.toJson(broadcastCustomEventRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }

  }

  @Test
  void getSystemStatsRequest() {
    GetSystemStatsRequest getSystemStatsRequest = GetSystemStatsRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetSystemStats\",\n" +
        "\t\"requestId\": " + getSystemStatsRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSystemStatsRequest);
  }

  @Test
  void getHotkeyListRequest() {
    GetHotkeyListRequest getHotkeyListRequest = GetHotkeyListRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetHotkeyList\",\n" +
        "\t\"requestId\": " + getHotkeyListRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getHotkeyListRequest);
  }

  @Test
  void getStudioModeEnabledRequest() {
    GetStudioModeEnabledRequest getStudioModeEnabledRequest = GetStudioModeEnabledRequest.builder()
        .build();

    String json = "{\n" +
        "\t\"requestType\": \"GetStudioModeEnabled\",\n" +
        "\t\"requestId\": " + getStudioModeEnabledRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}\n";

    assertSerializationAndDeserialization(json, getStudioModeEnabledRequest);
  }

  @Test
  void getProjectorListRequest() {
    GetProjectorListRequest getProjectorListRequest = GetProjectorListRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetProjectorList\",\n" +
        "\t\"requestId\": " + getProjectorListRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}\n";

    assertSerializationAndDeserialization(json, getProjectorListRequest);
  }

  @Test
  void openProjectorRequest() {
    OpenProjectorRequest openProjectorRequest = OpenProjectorRequest.builder()
        .projectorType(Projector.Type.MULTIVIEW)
        .projectorGeometry("GeometryString")
        .projectorMonitor(1)
        .sourceName("Source String name")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"projectorType\": \"MULTIVIEW\",\n" +
        "\t\t\"projectorMonitor\": 1,\n" +
        "\t\t\"projectorGeometry\": \"GeometryString\",\n" +
        "\t\t\"sourceName\": \"Source String name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"OpenProjector\",\n" +
        "\t\"requestId\": " + openProjectorRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, openProjectorRequest);
  }

  @Test
  void closeProjectorRequest() {
    CloseProjectorRequest closeProjectorRequest = CloseProjectorRequest.builder()
        .projectorName("projector 1")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"projectorName\": \"projector 1\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"CloseProjector\",\n" +
        "\t\"requestId\": " + closeProjectorRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, closeProjectorRequest);
  }

  @Test
  void setStudioModeEnabledRequest() {
    SetStudioModeEnabledRequest setStudioModeEnabledRequest = SetStudioModeEnabledRequest.builder()
        .studioModeEnabled(false).build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"studioModeEnabled\": false\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetStudioModeEnabled\",\n" +
        "\t\"requestId\": " + setStudioModeEnabledRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, setStudioModeEnabledRequest);
  }

  @Test
  void sleepRequest() {
    SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sleepMillis\": 1000\n" +
        "\t},\n" +
        "\t\"requestType\": \"Sleep\",\n" +
        "\t\"requestId\": " + sleepRequest1000.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    Request request = deserializeTo(json, Request.class);
    assertThat(request).isNotNull();
    assertThat(request.getRequestType()).isEqualTo(Request.Type.Sleep);
  }

  @Test
  void triggerHotkeyByNameRequest() {
    TriggerHotkeyByNameRequest triggerHotkeyByNameRequest = TriggerHotkeyByNameRequest.builder()
        .hotkeyName("Hotkey").build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"hotkeyName\": \"Hotkey\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"TriggerHotkeyByName\",\n" +
        "\t\"requestId\": " + triggerHotkeyByNameRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"keyId\": \"KeyId1\",\n" +
        "\t\t\"keyModifiers\": {\n" +
        "\t\t\t\"shift\": true,\n" +
        "\t\t\t\"alt\": true,\n" +
        "\t\t\t\"control\": false,\n" +
        "\t\t\t\"command\": false\n" +
        "\t\t}\n" +
        "\t},\n" +
        "\t\"requestType\": \"TriggerHotkeyByName\",\n" +
        "\t\"requestId\": " + triggerHotkeyByKeySequenceRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, triggerHotkeyByKeySequenceRequest);
  }
}
