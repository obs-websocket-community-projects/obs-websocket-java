package io.obswebsocket.community.client.translator.requestSerializationTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.stream.GetStreamServiceSettingsRequest;
import io.obswebsocket.community.client.message.request.stream.GetStreamStatusRequest;
import io.obswebsocket.community.client.message.request.stream.SendStreamCaptionRequest;
import io.obswebsocket.community.client.message.request.stream.SetStreamServiceSettingsRequest;
import io.obswebsocket.community.client.message.request.stream.StartStreamRequest;
import io.obswebsocket.community.client.message.request.stream.ToggleStreamRequest;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class StreamRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getStreamServiceSettingsRequest() {
    GetStreamServiceSettingsRequest getStreamServiceSettingsRequest = GetStreamServiceSettingsRequest
        .builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetStreamServiceSettings\",\n" +
        "\t\"requestId\": " + getStreamServiceSettingsRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getStreamServiceSettingsRequest);
  }

  @Test
  void getStreamStatusRequest() {
    GetStreamStatusRequest getStreamStatusRequest = GetStreamStatusRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetStreamStatus\",\n" +
        "\t\"requestId\": " + getStreamStatusRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getStreamStatusRequest);
  }

  @Test
  void sendStreamCaptionRequest() {
    SendStreamCaptionRequest sendStreamCaptionRequest = SendStreamCaptionRequest.builder()
        .captionText("Some random caption text")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"captionText\": \"Some random caption text\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SendStreamCaption\",\n" +
        "\t\"requestId\": " + sendStreamCaptionRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, sendStreamCaptionRequest);
  }

  @Test
  void setStreamServiceSettingsRequest() {
    JsonObject serviceSettings = new JsonObject();
    serviceSettings.addProperty("randomStringSetting", "randomString");
    serviceSettings.addProperty("randomBooleanSetting", true);
    serviceSettings.addProperty("randomIntegerSetting", 129);

    SetStreamServiceSettingsRequest setStreamServiceSettingsRequest = SetStreamServiceSettingsRequest
        .builder()
        .streamServiceType("Test Type")
        .serviceSettings(serviceSettings)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"streamServiceType\": \"Test Type\",\n" +
        "\t\t\"serviceSettings\": {\n" +
        "\t\t\t\"randomStringSetting\": \"randomString\",\n" +
        "\t\t\t\"randomBooleanSetting\": true,\n" +
        "\t\t\t\"randomIntegerSetting\": 129\n" +
        "\t\t}\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetStreamServiceSettings\",\n" +
        "\t\"requestId\": " + setStreamServiceSettingsRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    MessageTranslator translator = new GsonMessageTranslator();

    SetStreamServiceSettingsRequest actualObject = translator
        .fromJson(json, SetStreamServiceSettingsRequest.class);

    assertThat(
        actualObject.getRequestData().getServiceSettings().get("randomStringSetting").getAsString())
        .isEqualTo(setStreamServiceSettingsRequest.getRequestData().getServiceSettings()
            .get("randomStringSetting").getAsString());
    assertThat(actualObject.getRequestData().getServiceSettings().get("randomBooleanSetting")
        .getAsBoolean()).isEqualTo(
        setStreamServiceSettingsRequest.getRequestData().getServiceSettings()
            .get("randomBooleanSetting").getAsBoolean());
    assertThat(
        actualObject.getRequestData().getServiceSettings().get("randomIntegerSetting").getAsInt())
        .isEqualTo(setStreamServiceSettingsRequest.getRequestData().getServiceSettings()
            .get("randomIntegerSetting").getAsInt());
    assertThat(actualObject.getRequestId())
        .isEqualTo(setStreamServiceSettingsRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Type.SetStreamServiceSettings);
    assertThat(actualObject.getMessageType()).isEqualTo(Message.Type.Request);
    try {
      String actualJson = translator.toJson(setStreamServiceSettingsRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }

  @Test
  void startStreamRequest() {
    StartStreamRequest startStreamRequest = StartStreamRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"StartStream\",\n" +
        "\t\"requestId\": " + startStreamRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, startStreamRequest);
  }

  @Test
  void toggleStreamRequest() {
    ToggleStreamRequest toggleStreamRequest = ToggleStreamRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"ToggleStream\",\n" +
        "\t\"requestId\": " + toggleStreamRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, toggleStreamRequest);
  }
}
