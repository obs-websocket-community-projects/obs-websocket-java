package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ScenesRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getSceneListRequest() {
    GetSceneListRequest getSceneListRequest = GetSceneListRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getSceneListRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/GetSceneListRequest.json", vars);

    assertSerializationAndDeserialization(json, getSceneListRequest);
  }

  @Test
  void getGroupListRequest() {
    GetGroupListRequest getGroupListRequest = GetGroupListRequest.builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getGroupListRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/GetGroupListRequest.json", vars);

    assertSerializationAndDeserialization(json, getGroupListRequest);
  }

  @Test
  void getCurrentProgramSceneRequest() {
    GetCurrentProgramSceneRequest getCurrentProgramSceneRequest = GetCurrentProgramSceneRequest
        .builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getCurrentProgramSceneRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/GetCurrentProgramSceneRequest.json", vars);

    assertSerializationAndDeserialization(json, getCurrentProgramSceneRequest);
  }

  @Test
  void setCurrentProgramSceneRequest() {
    SetCurrentProgramSceneRequest setCurrentProgramSceneRequest = SetCurrentProgramSceneRequest
        .builder()
        .sceneName("Scene name")
        .build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", setCurrentProgramSceneRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/SetCurrentProgramSceneRequest.json", vars);

    assertSerializationAndDeserialization(json, setCurrentProgramSceneRequest);
  }

  @Test
  void getCurrentPreviewSceneRequest() {
    GetCurrentPreviewSceneRequest getCurrentPreviewSceneRequest = GetCurrentPreviewSceneRequest
        .builder().build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getCurrentPreviewSceneRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/GetCurrentPreviewSceneRequest.json", vars);

    assertSerializationAndDeserialization(json, getCurrentPreviewSceneRequest);
  }

  @Test
  void setCurrentPreviewSceneRequest() {
    SetCurrentPreviewSceneRequest setCurrentPreviewSceneRequest = SetCurrentPreviewSceneRequest
        .builder()
        .sceneName("Scene name")
        .build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", setCurrentPreviewSceneRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/SetCurrentPreviewSceneRequest.json", vars);

    assertSerializationAndDeserialization(json, setCurrentPreviewSceneRequest);
  }

  @Test
  void createSceneRequest() {
    CreateSceneRequest createSceneRequest = CreateSceneRequest.builder()
                                                              .sceneName("Scene name")
                                                              .build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", createSceneRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/CreateSceneRequest.json", vars);

    assertSerializationAndDeserialization(json, createSceneRequest);
  }

  @Test
  void removeSceneRequest() {
    RemoveSceneRequest removeSceneRequest = RemoveSceneRequest.builder()
        .sceneName("Scene name")
        .build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", removeSceneRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/RemoveSceneRequest.json", vars);

    assertSerializationAndDeserialization(json, removeSceneRequest);
  }

  @Test
  void setSceneNameRequest() {
    SetSceneNameRequest setSceneNameRequest = SetSceneNameRequest.builder()
        .sceneName("Scene name")
        .newSceneName("New Scene name")
        .build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", setSceneNameRequest.getRequestId());
    String json = this.readResourceFile("requests/scenes/SetSceneNameRequest.json", vars);

    assertSerializationAndDeserialization(json, setSceneNameRequest);
  }

  @Test
  void getSceneTransitionOverrideRequest() {
    GetSceneSceneTransitionOverrideRequest getSceneSceneTransitionOverrideRequest = GetSceneSceneTransitionOverrideRequest
        .builder()
        .sceneName("Scene name")
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'GetSceneSceneTransitionOverride',\n" +
        "\t'requestId': " + getSceneSceneTransitionOverrideRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneSceneTransitionOverrideRequest);
  }

  @Test
  void setSceneTransitionOverrideRequest() {
    SetSceneSceneTransitionOverrideRequest setSceneSceneTransitionOverrideRequest = SetSceneSceneTransitionOverrideRequest
        .builder()
        .sceneName("Scene name")
        .transitionName("Transition Name")
        .transitionDuration(3)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'transitionName': 'Transition Name',\n" +
        "\t\t'transitionDuration': 3,\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'SetSceneSceneTransitionOverride',\n" +
        "\t'requestId': " + setSceneSceneTransitionOverrideRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setSceneSceneTransitionOverrideRequest);
  }
}
