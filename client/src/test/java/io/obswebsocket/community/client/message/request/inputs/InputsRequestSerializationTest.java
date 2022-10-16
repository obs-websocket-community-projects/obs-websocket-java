package io.obswebsocket.community.client.message.request.inputs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.Message.OperationCode;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.model.Input;
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'CreateInput',\n" +
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
            "\t}}\n" +
            "}";

    MessageTranslator translator = new GsonMessageTranslator();

    CreateInputRequest actualObject = translator.fromJson(json, CreateInputRequest.class);

    assertThat(actualObject.getData().getRequestData().getInputKind())
            .isEqualTo(createInputRequest.getData().getRequestData().getInputKind());
    assertThat(actualObject.getData().getRequestData().getSceneName())
            .isEqualTo(createInputRequest.getData().getRequestData().getSceneName());
    assertThat(actualObject.getData().getRequestData().getSceneItemEnabled())
            .isEqualTo(createInputRequest.getData().getRequestData().getSceneItemEnabled());
    assertThat(
            actualObject.getData().getRequestData().getInputSettings().get("randomStringSetting").getAsString())
            .isEqualTo(createInputRequest.getData().getRequestData().getInputSettings().get("randomStringSetting")
                                         .getAsString());
    assertThat(
            actualObject.getData().getRequestData().getInputSettings().get("randomBooleanSetting").getAsBoolean())
            .isEqualTo(
                    createInputRequest.getData().getRequestData().getInputSettings().get("randomBooleanSetting")
                                      .getAsBoolean());
    assertThat(
            actualObject.getData().getRequestData().getInputSettings().get("randomIntegerSetting").getAsInt())
            .isEqualTo(
                    createInputRequest.getData().getRequestData().getInputSettings().get("randomIntegerSetting")
                                      .getAsInt());
    assertThat(actualObject.getRequestId()).isEqualTo(createInputRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Data.Type.CreateInput);
    assertThat(actualObject.getOperationCode()).isEqualTo(OperationCode.Request);
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputDefaultSettings',\n" +
            "\t'requestId': " + getInputDefaultSettingsRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputKind': 'input kind'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputDefaultSettingsRequest);
  }

  @Test
  void getInputListRequest() {
    GetInputListRequest getInputListRequest = GetInputListRequest.builder()
                                                                 .inputKind("input kind")
                                                                 .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputList',\n" +
            "\t'requestId': " + getInputListRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputKind': 'input kind'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputListRequest);
  }

  @Test
  void getInputKindListRequest() {
    GetInputKindListRequest getInputKindListRequest = GetInputKindListRequest.builder()
                                                                             .unversioned(false)
                                                                             .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputKindList',\n" +
            "\t'requestId': " + getInputKindListRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'unversioned': false\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputKindListRequest);
  }

  @Test
  void getInputAudioMonitorTypeRequest() {
    GetInputAudioMonitorTypeRequest getInputAudioMonitorTypeRequest = GetInputAudioMonitorTypeRequest.builder()
                                                                                                     .inputName("input")
                                                                                                     .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputAudioMonitorType',\n" +
            "\t'requestId': " + getInputAudioMonitorTypeRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputAudioMonitorTypeRequest);
  }

  @Test
  void getInputMuteRequest() {
    GetInputMuteRequest getInputMuteRequest = GetInputMuteRequest.builder()
                                                                 .inputName("input")
                                                                 .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputMute',\n" +
            "\t'requestId': " + getInputMuteRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputMuteRequest);
  }

  @Test
  void getInputSettingsRequest() {
    GetInputSettingsRequest getInputSettingsRequest = GetInputSettingsRequest.builder()
                                                                             .inputName("input")
                                                                             .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputSettings',\n" +
            "\t'requestId': " + getInputSettingsRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputSettingsRequest);
  }

  @Test
  void getInputAudioTracksRequest() {
    GetInputAudioTracksRequest getInputAudioTracks = GetInputAudioTracksRequest.builder()
                                                                               .inputName("input")
                                                                               .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputAudioTracks',\n" +
            "\t'requestId': " + getInputAudioTracks.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, getInputAudioTracks);
  }

  @Test
  void getInputVolumeRequest() {
    GetInputVolumeRequest getInputVolumeRequest = GetInputVolumeRequest.builder()
                                                                       .inputName("input")
                                                                       .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'GetInputVolume',\n" +
            "\t'requestId': " + getInputVolumeRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'SetInputAudioMonitorType',\n" +
            "\t'requestId': " + setInputAudioMonitorTypeRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'monitorType': 'OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT',\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'SetInputMute',\n" +
            "\t'requestId': " + setInputMuteRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputMuted': true,\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'SetInputName',\n" +
            "\t'requestId': " + setInputNameRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'newInputName': 'awesome new input name',\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'SetInputSettings',\n" +
            "\t'requestId': " + setInputSettingsRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputSettings': {\n" +
            "\t\t\t'randomStringSetting': 'randomString',\n" +
            "\t\t\t'randomBooleanSetting': true,\n" +
            "\t\t\t'randomIntegerSetting': 18\n" +
            "\t\t},\n" +
            "\t\t'overlay': true,\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    MessageTranslator translator = new GsonMessageTranslator();

    SetInputSettingsRequest actualObject = translator.fromJson(json, SetInputSettingsRequest.class);

    assertThat(actualObject.getData().getRequestData().getInputName())
            .isEqualTo(setInputSettingsRequest.getData().getRequestData().getInputName());
    assertThat(actualObject.getData().getRequestData().getOverlay())
            .isEqualTo(setInputSettingsRequest.getData().getRequestData().getOverlay());
    assertThat(
            actualObject.getData().getRequestData().getInputSettings().get("randomStringSetting").getAsString())
            .isEqualTo(
                    setInputSettingsRequest.getData().getRequestData().getInputSettings().get("randomStringSetting")
                                           .getAsString());
    assertThat(
            actualObject.getData().getRequestData().getInputSettings().get("randomBooleanSetting").getAsBoolean())
            .isEqualTo(
                    setInputSettingsRequest.getData().getRequestData().getInputSettings().get("randomBooleanSetting")
                                           .getAsBoolean());
    assertThat(
            actualObject.getData().getRequestData().getInputSettings().get("randomIntegerSetting").getAsInt())
            .isEqualTo(
                    setInputSettingsRequest.getData().getRequestData().getInputSettings().get("randomIntegerSetting")
                                           .getAsInt());
    assertThat(actualObject.getRequestId()).isEqualTo(setInputSettingsRequest.getRequestId());
    assertThat(actualObject.getRequestType()).isEqualTo(Request.Data.Type.SetInputSettings);
    assertThat(actualObject.getOperationCode()).isEqualTo(OperationCode.Request);
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
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'SetInputVolume',\n" +
            "\t'requestId': " + setInputVolumeRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputVolumeDb': 12.0,\n" +
            "\t\t'inputVolumeMul': 2.0,\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, setInputVolumeRequest);
  }

  @Test
  void toggleInputMuteRequest() {
    ToggleInputMuteRequest toggleInputMuteRequest = ToggleInputMuteRequest.builder()
                                                                          .inputName("input")
                                                                          .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'ToggleInputMute',\n" +
            "\t'requestId': " + toggleInputMuteRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, toggleInputMuteRequest);
  }

  @Test
  void removeInputRequest() {
    RemoveInputRequest removeInputRequest = RemoveInputRequest.builder()
                                                              .inputName("input 1")
                                                              .build();

    String json = "{\n" +
            "\t'op': 6,\n" +
            "\t'd': {'requestType': 'RemoveInput',\n" +
            "\t'requestId': " + removeInputRequest.getRequestId() + ",\n" +
            "\t'requestData': {\n" +
            "\t\t'inputName': 'input 1'\n" +
            "\t}}\n" +
            "}";

    assertSerializationAndDeserialization(json, removeInputRequest);
  }
}
