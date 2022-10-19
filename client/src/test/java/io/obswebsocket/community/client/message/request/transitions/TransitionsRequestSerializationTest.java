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
  void getCurrentSceneTransitionRequest() {
    GetCurrentSceneTransitionRequest getCurrentSceneTransitionRequest = GetCurrentSceneTransitionRequest.builder()
        .build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetCurrentSceneTransition',\n" +
        "\t'requestId': " + getCurrentSceneTransitionRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getCurrentSceneTransitionRequest);
  }

  @Test
  void getSceneTransitionListRequest() {
    GetSceneTransitionListRequest getSceneTransitionListRequest = GetSceneTransitionListRequest.builder()
        .build();

    String json = "{'d': {\n" +
        "\t'requestType': 'GetSceneTransitionList',\n" +
        "\t'requestId': " + getSceneTransitionListRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneTransitionListRequest);
  }

  @Test
  void setCurrentSceneTransitionDurationRequest() {
    SetCurrentSceneTransitionDurationRequest setCurrentSceneTransitionDurationRequest = SetCurrentSceneTransitionDurationRequest
        .builder()
        .transitionDuration(120)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionDuration': 120\n" +
        "\t},\n" +
        "\t'requestType': 'SetCurrentSceneTransitionDuration',\n" +
        "\t'requestId': " + setCurrentSceneTransitionDurationRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setCurrentSceneTransitionDurationRequest);
  }

  @Test
  void setCurrentSceneTransitionRequest() {
    SetCurrentSceneTransitionRequest setCurrentSceneTransitionRequest = SetCurrentSceneTransitionRequest.builder()
        .transitionName("Cool transition")
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionName': 'Cool transition'\n" +
        "\t},\n" +
        "\t'requestType': 'SetCurrentSceneTransition',\n" +
        "\t'requestId': " + setCurrentSceneTransitionRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setCurrentSceneTransitionRequest);
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
        "\t'requestType': 'SetTBarPosition',\n" +
        "\t'requestId': " + setTbarPositionRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setTbarPositionRequest);
  }

  @Test
  void setCurrentSceneTransitionSettingsRequest() {
    JsonObject transitionSettings = new JsonObject();
    transitionSettings.addProperty("randomStringSetting", "randomString");
    transitionSettings.addProperty("randomBooleanSetting", true);
    transitionSettings.addProperty("randomIntegerSetting", 123);

    SetCurrentSceneTransitionSettingsRequest setTransitionSettingsRequest = SetCurrentSceneTransitionSettingsRequest
        .builder()
        .transitionSettings(transitionSettings)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionSettings': {\n" +
        "\t\t\t'randomStringSetting': 'randomString',\n" +
        "\t\t\t'randomBooleanSetting': true,\n" +
        "\t\t\t'randomIntegerSetting': 123\n" +
        "\t\t}\n" +
        "\t},\n" +
        "\t'requestType': 'SetCurrentSceneTransitionSettings',\n" +
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
