package io.obswebsocket.community.client.message.request.inputs;

import com.google.gson.JsonObject;
import com.google.gson.internal.LazilyParsedNumber;
import io.obswebsocket.community.client.message.request.AbstractRequestSerializationTest;
import io.obswebsocket.community.client.model.Input;
import io.obswebsocket.community.client.model.Input.AudioTracks;
import org.junit.jupiter.api.Test;

public class InputsRequestSerializationTest extends AbstractRequestSerializationTest {

  private static final String TYPE = "inputs";

  @Test
  void getInputListRequest() {
    GetInputListRequest getInputListRequest = GetInputListRequest.builder()
        .inputKind("input kind")
        .build();

    assertRequest(TYPE, getInputListRequest);
  }

  @Test
  void getInputKindListRequest() {
    GetInputKindListRequest getInputKindListRequest = GetInputKindListRequest.builder()
        .unversioned(false)
        .build();

    assertRequest(TYPE, getInputKindListRequest);
  }

  @Test
  void getSpecialInputsRequest() {
    GetSpecialInputsRequest getSpecialInputsRequest = GetSpecialInputsRequest.builder().build();

    assertRequest(TYPE, getSpecialInputsRequest);
  }

  @Test
  void createInputRequest() {
    JsonObject inputSettings = new JsonObject();
    inputSettings.addProperty("randomStringSetting", "randomString");
    inputSettings.addProperty("randomBooleanSetting", false);
    inputSettings.addProperty("randomIntegerSetting", new LazilyParsedNumber("32"));

    CreateInputRequest createInputRequest = CreateInputRequest.builder()
        .inputName("Mic Input")
        .inputKind("input kind")
        .sceneName("scene")
        .inputSettings(inputSettings)
        .sceneItemEnabled(true)
        .build();

    assertRequest(TYPE, createInputRequest);
  }

  @Test
  void removeInputRequest() {
    RemoveInputRequest removeInputRequest = RemoveInputRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, removeInputRequest);
  }

  @Test
  void setInputNameRequest() {
    SetInputNameRequest setInputNameRequest = SetInputNameRequest.builder()
        .inputName("Mic Input")
        .newInputName("Mic 1")
        .build();

    assertRequest(TYPE, setInputNameRequest);
  }

  @Test
  void getInputDefaultSettings() {
    GetInputDefaultSettingsRequest getInputDefaultSettingsRequest = GetInputDefaultSettingsRequest
        .builder()
        .inputKind("input kind")
        .build();

    assertRequest(TYPE, getInputDefaultSettingsRequest);
  }

  @Test
  void getInputSettingsRequest() {
    GetInputSettingsRequest getInputSettingsRequest = GetInputSettingsRequest.builder()
        .inputName("Input Name")
        .build();

    assertRequest(TYPE, getInputSettingsRequest);
  }

  @Test
  void setInputSettingsRequest() {
    JsonObject inputSettings = new JsonObject();
    inputSettings.addProperty("randomStringSetting", "randomString");
    inputSettings.addProperty("randomBooleanSetting", false);
    inputSettings.addProperty("randomIntegerSetting", new LazilyParsedNumber("32"));

    SetInputSettingsRequest setInputSettingsRequest = SetInputSettingsRequest.builder()
        .inputName("Mic Input")
        .inputSettings(inputSettings)
        .overlay(true)
        .build();

    assertRequest(TYPE, setInputSettingsRequest);
  }

  @Test
  void getInputMuteRequest() {
    GetInputMuteRequest getInputMuteRequest = GetInputMuteRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, getInputMuteRequest);
  }

  @Test
  void setInputMuteRequest() {
    SetInputMuteRequest setInputMuteRequest = SetInputMuteRequest.builder()
        .inputName("Mic Input")
        .inputMuted(true)
        .build();

    assertRequest(TYPE, setInputMuteRequest);
  }

  @Test
  void toggleInputMuteRequest() {
    ToggleInputMuteRequest toggleInputMuteRequest = ToggleInputMuteRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, toggleInputMuteRequest);
  }

  @Test
  void getInputVolumeRequest() {
    GetInputVolumeRequest getInputVolumeRequest = GetInputVolumeRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, getInputVolumeRequest);
  }

  @Test
  void setInputVolumeRequest() {
    SetInputVolumeRequest setInputVolumeRequest = SetInputVolumeRequest.builder()
        .inputName("Mic Input")
        .inputVolumeDb(12f)
        .inputVolumeMul(2f)
        .build();

    assertRequest(TYPE, setInputVolumeRequest);
  }

  @Test
  void getInputAudioBalanceRequest() {
    GetInputAudioBalanceRequest getInputAudioBalanceRequest = GetInputAudioBalanceRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, getInputAudioBalanceRequest);
  }

  @Test
  void setInputAudioBalanceRequest() {
    SetInputAudioBalanceRequest setInputAudioBalanceRequest = SetInputAudioBalanceRequest.builder()
        .inputName("Mic Input")
        .inputAudioBalance(0.5f)
        .build();

    assertRequest(TYPE, setInputAudioBalanceRequest);
  }

  @Test
  void getInputAudioSyncOffsetRequest() {
    GetInputAudioSyncOffsetRequest getInputAudioSyncOffsetRequest = GetInputAudioSyncOffsetRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, getInputAudioSyncOffsetRequest);
  }

  @Test
  void setInputAudioSyncOffsetRequest() {
    SetInputAudioSyncOffsetRequest setInputAudioSyncOffsetRequest = SetInputAudioSyncOffsetRequest.builder()
        .inputName("Mic Input")
        .inputAudioSyncOffset(120L)
        .build();

    assertRequest(TYPE, setInputAudioSyncOffsetRequest);
  }

  @Test
  void getInputAudioMonitorTypeRequest() {
    GetInputAudioMonitorTypeRequest getInputAudioMonitorTypeRequest = GetInputAudioMonitorTypeRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, getInputAudioMonitorTypeRequest);
  }

  @Test
  void setInputAudioMonitorTypeRequest() {
    SetInputAudioMonitorTypeRequest setInputAudioMonitorTypeRequest = SetInputAudioMonitorTypeRequest.builder()
        .inputName("Mic Input")
        .monitorType(Input.MonitorType.MONITOR_AND_OUTPUT)
        .build();

    assertRequest(TYPE, setInputAudioMonitorTypeRequest);
  }

  @Test
  void getInputAudioTracksRequest() {
    GetInputAudioTracksRequest getInputAudioTracks = GetInputAudioTracksRequest.builder()
        .inputName("Mic Input")
        .build();

    assertRequest(TYPE, getInputAudioTracks);
  }

  @Test
  void setInputAudioTracksRequest() {
    SetInputAudioTracksRequest setInputAudioTracks = SetInputAudioTracksRequest.builder()
        .inputName("Mic Input")
        .inputAudioTracks(AudioTracks.builder()
            .one(true)
            .two(true)
            .three(true)
            .four(true)
            .five(true)
            .six(true)
            .build())
        .build();

    assertRequest(TYPE, setInputAudioTracks);
  }

  @Test
  void getInputPropertiesListPropertyItemsRequest() {
    GetInputPropertiesListPropertyItemsRequest getInputPropertiesListPropertyItemsRequest = GetInputPropertiesListPropertyItemsRequest.builder()
        .inputName("Mic Input")
        .propertyName("Property Name")
        .build();

    assertRequest(TYPE, getInputPropertiesListPropertyItemsRequest);
  }

  @Test
  void pressInputPropertiesButtonRequest() {
    PressInputPropertiesButtonRequest pressInputPropertiesButtonRequest = PressInputPropertiesButtonRequest.builder()
        .inputName("Mic Input")
        .propertyName("Property Name")
        .build();

    assertRequest(TYPE, pressInputPropertiesButtonRequest);
  }
}
