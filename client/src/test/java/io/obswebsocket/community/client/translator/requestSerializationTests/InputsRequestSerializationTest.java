package io.obswebsocket.community.client.translator.requestSerializationTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.inputs.CreateInputRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputDefaultSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputKindListRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputListRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputAudioMonitorTypeRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputMuteRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputAudioTracksRequest;
import io.obswebsocket.community.client.message.request.inputs.GetInputVolumeRequest;
import io.obswebsocket.community.client.message.request.inputs.RemoveInputRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputAudioMonitorTypeRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputMuteRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputNameRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputSettingsRequest;
import io.obswebsocket.community.client.message.request.inputs.SetInputVolumeRequest;
import io.obswebsocket.community.client.message.request.inputs.ToggleInputMuteRequest;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class InputsRequestSerializationTest extends AbstractSerializationTest {

  @Test
  void createInputRequest() {
    JsonObject inputSettings = new JsonObject();
    inputSettings.addProperty("randomStringSetting", "randomString");
    inputSettings.addProperty("randomBooleanSetting", false);
    inputSettings.addProperty("randomIntegerSetting", 32);

    CreateInputRequest createInputRequest = CreateInputRequest.builder()
        .inputName("Mic Input")
        .inputKind("input kind")
        .sceneName("scene")
        .inputSettings(inputSettings)
        .sceneItemEnabled(true)
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'CreateInput',\n" +
        "\t'requestId': " + createInputRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputKind': 'input kind',\n" +
        "\t\t'sceneName': 'scene',\n" +
        "\t\t'inputSettings': {\n" +
        "\t\t\t'randomStringSetting': 'randomString',\n" +
        "\t\t\t'randomBooleanSetting': false,\n" +
        "\t\t\t'randomIntegerSetting': 32\n" +
        "\t\t},\n" +
        "\t\t'sceneItemEnabled': true,\n" +
        "\t\t'inputName': 'Mic Input'\n" +
        "\t}\n" +
        "}";

    MessageTranslator translator = new GsonMessageTranslator();

    CreateInputRequest actualObject = translator.fromJson(json, CreateInputRequest.class);

    assertThat(actualObject.getRequestData().getInputKind())
        .isEqualTo(createInputRequest.getRequestData().getInputKind());
    assertThat(actualObject.getRequestData().getSceneName())
        .isEqualTo(createInputRequest.getRequestData().getSceneName());
    assertThat(actualObject.getRequestData().getSceneItemEnabled())
        .isEqualTo(createInputRequest.getRequestData().getSceneItemEnabled());
    assertThat(
        actualObject.getRequestData().getInputSettings().get("randomStringSetting").getAsString())
        .isEqualTo(createInputRequest.getRequestData().getInputSettings().get("randomStringSetting")
            .getAsString());
    assertThat(
        actualObject.getRequestData().getInputSettings().get("randomBooleanSetting").getAsBoolean())
        .isEqualTo(
            createInputRequest.getRequestData().getInputSettings().get("randomBooleanSetting")
                .getAsBoolean());
    assertThat(
        actualObject.getRequestData().getInputSettings().get("randomIntegerSetting").getAsInt())
        .isEqualTo(
            createInputRequest.getRequestData().getInputSettings().get("randomIntegerSetting")
                .getAsInt());
    assertThat(actualObject.getRequestId()).isEqualTo(createInputRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Type.CreateInput);
    assertThat(actualObject.getMessageType()).isEqualTo(Message.Type.Request);
    try {
      String actualJson = translator.toJson(createInputRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }

  @Test
  void getInputDefaultSettings() {
    GetInputDefaultSettingsRequest getInputDefaultSettingsRequest = GetInputDefaultSettingsRequest
        .builder()
        .inputKind("input kind")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputDefaultSettings',\n" +
        "\t'requestId': " + getInputDefaultSettingsRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputKind': 'input kind'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputDefaultSettingsRequest);
  }

  @Test
  void getInputListRequest() {
    GetInputListRequest getInputListRequest = GetInputListRequest.builder()
        .inputKind("input kind")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputList',\n" +
        "\t'requestId': " + getInputListRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputKind': 'input kind'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputListRequest);
  }

  @Test
  void getInputKindListRequest() {
    GetInputKindListRequest getInputKindListRequest = GetInputKindListRequest.builder()
        .unversioned(false)
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputKindList',\n" +
        "\t'requestId': " + getInputKindListRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'unversioned': false\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputKindListRequest);
  }

  @Test
  void getInputAudioMonitorTypeRequest() {
    GetInputAudioMonitorTypeRequest getInputAudioMonitorTypeRequest = GetInputAudioMonitorTypeRequest.builder()
        .inputName("input")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputAudioMonitorType',\n" +
        "\t'requestId': " + getInputAudioMonitorTypeRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputAudioMonitorTypeRequest);
  }

  @Test
  void getInputMuteRequest() {
    GetInputMuteRequest getInputMuteRequest = GetInputMuteRequest.builder()
        .inputName("input")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputMute',\n" +
        "\t'requestId': " + getInputMuteRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputMuteRequest);
  }

  @Test
  void getInputSettingsRequest() {
    GetInputSettingsRequest getInputSettingsRequest = GetInputSettingsRequest.builder()
        .inputName("input")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputSettings',\n" +
        "\t'requestId': " + getInputSettingsRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputSettingsRequest);
  }

  @Test
  void getInputAudioTracksRequest() {
    GetInputAudioTracksRequest getInputAudioTracks = GetInputAudioTracksRequest.builder()
        .inputName("input")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputAudioTracks',\n" +
        "\t'requestId': " + getInputAudioTracks.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputAudioTracks);
  }

  @Test
  void getInputVolumeRequest() {
    GetInputVolumeRequest getInputVolumeRequest = GetInputVolumeRequest.builder()
        .inputName("input")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetInputVolume',\n" +
        "\t'requestId': " + getInputVolumeRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getInputVolumeRequest);
  }

  @Test
  void setInputAudioMonitorTypeRequest() {
    SetInputAudioMonitorTypeRequest setInputAudioMonitorTypeRequest = SetInputAudioMonitorTypeRequest.builder()
        .inputName("input")
        .monitorType(Input.MonitorType.MONITOR_AND_OUTPUT)
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetInputAudioMonitorType',\n" +
        "\t'requestId': " + setInputAudioMonitorTypeRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'monitorType': 'monitorAndOutput',\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setInputAudioMonitorTypeRequest);
  }

  @Test
  void setInputMuteRequest() {
    SetInputMuteRequest setInputMuteRequest = SetInputMuteRequest.builder()
        .inputName("input")
        .inputMuted(true)
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetInputMute',\n" +
        "\t'requestId': " + setInputMuteRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputMuted': true,\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setInputMuteRequest);
  }

  @Test
  void setInputNameRequest() {
    SetInputNameRequest setInputNameRequest = SetInputNameRequest.builder()
        .inputName("input")
        .newInputName("awesome new input name")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetInputName',\n" +
        "\t'requestId': " + setInputNameRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'newInputName': 'awesome new input name',\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setInputNameRequest);
  }

  @Test
  void setInputSettingsRequest() {
    JsonObject inputSettings = new JsonObject();
    inputSettings.addProperty("randomStringSetting", "randomString");
    inputSettings.addProperty("randomBooleanSetting", true);
    inputSettings.addProperty("randomIntegerSetting", 18);

    SetInputSettingsRequest setInputSettingsRequest = SetInputSettingsRequest.builder()
        .inputName("input")
        .inputSettings(inputSettings)
        .overlay(true)
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetInputSettings',\n" +
        "\t'requestId': " + setInputSettingsRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputSettings': {\n" +
        "\t\t\t'randomStringSetting': 'randomString',\n" +
        "\t\t\t'randomBooleanSetting': true,\n" +
        "\t\t\t'randomIntegerSetting': 18\n" +
        "\t\t},\n" +
        "\t\t'overlay': true,\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    MessageTranslator translator = new GsonMessageTranslator();

    SetInputSettingsRequest actualObject = translator.fromJson(json, SetInputSettingsRequest.class);

    assertThat(actualObject.getRequestData().getInputName())
        .isEqualTo(setInputSettingsRequest.getRequestData().getInputName());
    assertThat(actualObject.getRequestData().getOverlay())
        .isEqualTo(setInputSettingsRequest.getRequestData().getOverlay());
    assertThat(
        actualObject.getRequestData().getInputSettings().get("randomStringSetting").getAsString())
        .isEqualTo(
            setInputSettingsRequest.getRequestData().getInputSettings().get("randomStringSetting")
                .getAsString());
    assertThat(
        actualObject.getRequestData().getInputSettings().get("randomBooleanSetting").getAsBoolean())
        .isEqualTo(
            setInputSettingsRequest.getRequestData().getInputSettings().get("randomBooleanSetting")
                .getAsBoolean());
    assertThat(
        actualObject.getRequestData().getInputSettings().get("randomIntegerSetting").getAsInt())
        .isEqualTo(
            setInputSettingsRequest.getRequestData().getInputSettings().get("randomIntegerSetting")
                .getAsInt());
    assertThat(actualObject.getRequestId()).isEqualTo(setInputSettingsRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Type.SetInputSettings);
    assertThat(actualObject.getMessageType()).isEqualTo(Message.Type.Request);
    try {
      String actualJson = translator.toJson(setInputSettingsRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }

  @Test
  void setInputVolumeRequest() {
    SetInputVolumeRequest setInputVolumeRequest = SetInputVolumeRequest.builder()
        .inputName("input")
        .inputVolumeDb(12f)
        .inputVolumeMul(2f)
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetInputVolume',\n" +
        "\t'requestId': " + setInputVolumeRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputVolumeDb': 12.0,\n" +
        "\t\t'inputVolumeMul': 2.0,\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setInputVolumeRequest);
  }

  @Test
  void toggleInputMuteRequest() {
    ToggleInputMuteRequest toggleInputMuteRequest = ToggleInputMuteRequest.builder()
        .inputName("input")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'ToggleInputMute',\n" +
        "\t'requestId': " + toggleInputMuteRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, toggleInputMuteRequest);
  }

  @Test
  void removeInputRequest() {
    RemoveInputRequest removeInputRequest = RemoveInputRequest.builder()
        .inputName("input 1")
        .build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'RemoveInput',\n" +
        "\t'requestId': " + removeInputRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'inputName': 'input 1'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, removeInputRequest);
  }
}
