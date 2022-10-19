package io.obswebsocket.community.client.message.request.transitions;

import static org.assertj.core.api.Fail.fail;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.translator.GsonMessageTranslator;
import io.obswebsocket.community.client.translator.MessageTranslator;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TransitionsRequestSerializationTest extends AbstractSerializationTest {

  @Test
  void getCurrentTransitionRequest() {
    GetCurrentSceneTransitionRequest getCurrentTransitionRequest = GetCurrentSceneTransitionRequest.builder()
        .build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetCurrentTransition',\n" +
        "\t'requestId': " + getCurrentTransitionRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getCurrentTransitionRequest);
  }

  @Test
  void getTransitionListRequest() {
    GetSceneTransitionListRequest getTransitionListRequest = GetSceneTransitionListRequest.builder()
        .build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetTransitionList',\n" +
        "\t'requestId': " + getTransitionListRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getTransitionListRequest);
  }

  @Test
  void setCurrentTransitionDurationRequest() {
    SetCurrentSceneTransitionDurationRequest setCurrentTransitionDurationRequest = SetCurrentSceneTransitionDurationRequest
        .builder()
        .transitionDuration(120)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionDuration': 120\n" +
        "\t},\n" +
        "\t'requestType': 'SetCurrentTransitionDuration',\n" +
        "\t'requestId': " + setCurrentTransitionDurationRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setCurrentTransitionDurationRequest);
  }

  @Test
  void setCurrentTransitionRequest() {
    SetCurrentSceneTransitionRequest setCurrentTransitionRequest = SetCurrentSceneTransitionRequest.builder()
        .transitionName("Cool transition")
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionName': 'Cool transition'\n" +
        "\t},\n" +
        "\t'requestType': 'SetCurrentTransition',\n" +
        "\t'requestId': " + setCurrentTransitionRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setCurrentTransitionRequest);
  }

  @Test
  void setTbarPositionRequest() {
    SetTBarPositionRequest setTbarPositionRequest = SetTBarPositionRequest.builder()
        .position(2.6)
        .release(true)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'position': 2.6,\n" +
        "\t\t'release': true\n" +
        "\t},\n" +
        "\t'requestType': 'SetTbarPosition',\n" +
        "\t'requestId': " + setTbarPositionRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setTbarPositionRequest);
  }

  @Test
  void setTransitionSettingsRequest() {
    // TODO
    JsonObject transitionSettings = new JsonObject();
    transitionSettings.addProperty("randomStringSetting", "randomString");
    transitionSettings.addProperty("randomBooleanSetting", true);
    transitionSettings.addProperty("randomIntegerSetting", 123);

    SetCurrentSceneTransitionSettingsRequest setTransitionSettingsRequest = SetCurrentSceneTransitionSettingsRequest
        .builder()
//            .transitionName("Transition name")
        .transitionSettings(transitionSettings)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionSettings': {\n" +
        "\t\t\t'randomStringSetting': 'randomString',\n" +
        "\t\t\t'randomBooleanSetting': true,\n" +
        "\t\t\t'randomIntegerSetting': 123\n" +
        "\t\t},\n" +
        "\t\t'transitionName': 'Transition name'\n" +
        "\t},\n" +
        "\t'requestType': 'SetTransitionSettings',\n" +
        "\t'requestId': " + setTransitionSettingsRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    MessageTranslator translator = new GsonMessageTranslator();

    SetCurrentSceneTransitionSettingsRequest actualObject = translator
        .fromJson(json, SetCurrentSceneTransitionSettingsRequest.class);

//    assertThat(actualObject.getData().getRequestData().getTransitionName())
//            .isEqualTo(setTransitionSettingsRequest.getData().getRequestData().getTransitionName());
//    assertThat(actualObject.getData().getRequestData().getTransitionSettings().get("randomStringSetting")
//                           .getAsString()).isEqualTo(
//            setTransitionSettingsRequest.getData().getRequestData().getTransitionSettings()
//                                        .get("randomStringSetting").getAsString());
//    assertThat(actualObject.getData().getRequestData().getTransitionSettings().get("randomBooleanSetting")
//                           .getAsBoolean()).isEqualTo(
//            setTransitionSettingsRequest.getData().getRequestData().getTransitionSettings()
//                                        .get("randomBooleanSetting").getAsBoolean());
//    assertThat(actualObject.getData().getRequestData().getTransitionSettings().get("randomIntegerSetting")
//                           .getAsBoolean()).isEqualTo(
//            setTransitionSettingsRequest.getData().getRequestData().getTransitionSettings()
//                                        .get("randomIntegerSetting").getAsBoolean());
//    assertThat(actualObject.getRequestId()).isEqualTo(setTransitionSettingsRequest.getRequestId());
//    assertThat(actualObject.getRequestType()).isEqualTo(RequestType.SetTransitionSettings);
//    assertThat(actualObject.getOperationCode()).isEqualTo(OperationCode.Request);
    try {
      String actualJson = translator.toJson(setTransitionSettingsRequest);
      System.out.println("Serialized to: " + actualJson);
      JSONAssert.assertEquals(json, actualJson, false);
    } catch (JSONException e) {
      fail("Could not assert against JSON", e);
    }
  }

  @Test
  void triggerStudioModeTransitionRequest() {
    TriggerStudioModeTransitionRequest triggerStudioModeTransitionRequest = TriggerStudioModeTransitionRequest
            .builder().build();

    String json = "{'d': {\n" +
            "\t'requestType': 'TriggerStudioModeTransition',\n" +
            "\t'requestId': " + triggerStudioModeTransitionRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, triggerStudioModeTransitionRequest);
  }
}
