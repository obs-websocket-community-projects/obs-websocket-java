package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.config.PersistentDataRequest.SpecificData.Realm;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class ConfigRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getPersistentDataRequest() {
    GetPersistentDataRequest getPersistentDataRequest = GetPersistentDataRequest
        .builder().realm(Realm.GLOBAL).slotName("Slot Name").build();

    HashMap<String, String> vars = new HashMap<>();
    vars.put("requestId", getPersistentDataRequest.getRequestId());
    String json = this.readResourceFile("requests/config/GetPersistentDataRequest.json", vars);

    assertSerializationAndDeserialization(json, getPersistentDataRequest);
  }

  @Test
  void setPersistentDataRequest() {
    SetPersistentDataRequest setPersistentDataRequest = SetPersistentDataRequest
        .builder().realm(Realm.PROFILE).slotName("Slot Name").slotValue("value").build();

    String json = "{\n" +
        "\t'op': 6\n," +
        "\t'd': {\n" +
        "\t\t'requestType': 'SetPersistentData',\n" +
        "\t\t'requestId': " + setPersistentDataRequest.getRequestId() + ",\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'realm': 'OBS_WEBSOCKET_DATA_REALM_PROFILE'\n," +
        "\t\t\t'slotName': 'Slot Name',\n" +
        "\t\t\t'slotValue': 'value'\n" +
        "\t\t}\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setPersistentDataRequest);
  }

  @Test
  void createSceneCollectionRequest() {
    CreateSceneCollectionRequest createSceneCollectionRequest = CreateSceneCollectionRequest
        .builder().sceneCollectionName("Collection Name").build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'SetCurrentSceneCollection',\n" +
        "\t\t'requestId': " + createSceneCollectionRequest.getRequestId() + ",\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'sceneCollectionName': 'Collection Name'\n" +
        "\t\t}\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, createSceneCollectionRequest);
  }

  @Test
  void getProfileListRequest() {
    GetProfileListRequest getProfileListRequest = GetProfileListRequest.builder().build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'GetProfileList',\n" +
        "\t\t'requestId': " + getProfileListRequest.getRequestId() + "\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getProfileListRequest);
  }

  @Test
  void getProfileParameterRequest() {
    GetProfileParameterRequest getProfileParameterRequest = GetProfileParameterRequest.builder()
        .parameterCategory("Category Name")
        .parameterName("Parameter Name")
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'GetProfileParameter',\n" +
        "\t\t'requestId': " + getProfileParameterRequest.getRequestId() + ",\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'parameterCategory': 'Category Name',\n" +
        "\t\t\t'parameterName': 'Parameter Name'\n" +
        "\t\t}\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getProfileParameterRequest);
  }

  @Test
  void getSceneCollectionListRequest() {
    GetSceneCollectionListRequest getSceneCollectionListRequest = GetSceneCollectionListRequest
        .builder().build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'GetSceneCollectionList',\n" +
        "\t\t'requestId': " + getSceneCollectionListRequest.getRequestId() + "\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneCollectionListRequest);
  }

  @Test
  void getVideoSettingsRequest() {
    GetVideoSettingsRequest getVideoSettingsRequest = GetVideoSettingsRequest.builder().build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'GetVideoSettings',\n" +
        "\t\t'requestId': " + getVideoSettingsRequest.getRequestId() + "\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getVideoSettingsRequest);
  }

  @Test
  void removeSceneCollectionRequest() {
    RemoveSceneCollectionRequest removeSceneCollectionRequest = RemoveSceneCollectionRequest
        .builder()
        .sceneCollectionName("Collection Name")
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'RemoveSceneCollection',\n" +
        "\t\t'requestId': " + removeSceneCollectionRequest.getRequestId() + ",\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'sceneCollectionName': 'Collection Name'\n" +
        "\t\t}\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, removeSceneCollectionRequest);
  }

  @Test
  void setCurrentSceneCollectionRequest() {
    SetCurrentSceneCollectionRequest setCurrentSceneCollectionRequest = SetCurrentSceneCollectionRequest
        .builder()
        .sceneCollectionName("Collection Name")
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'SetCurrentSceneCollection',\n" +
        "\t\t'requestId': " + setCurrentSceneCollectionRequest.getRequestId() + ",\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'sceneCollectionName': 'Collection Name'\n" +
        "\t\t}\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setCurrentSceneCollectionRequest);
  }

  @Test
  void setProfileParameterRequest() {
    SetProfileParameterRequest setProfileParameterRequest = SetProfileParameterRequest.builder()
        .parameterCategory("Category")
        .parameterName("Param")
        .parameterValue("new Value")
        .build();

    String json = "{\n" +
        "\t'op': 6,\n" +
        "\t'd': {\n" +
        "\t\t'requestType': 'SetProfileParameter',\n" +
        "\t\t'requestId': " + setProfileParameterRequest.getRequestId() + ",\n" +
        "\t\t'requestData': {\n" +
        "\t\t\t'parameterCategory': 'Category',\n" +
        "\t\t\t'parameterName': 'Param',\n" +
        "\t\t\t'parameterValue': 'new Value'\n" +
        "\t\t}\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setProfileParameterRequest);
  }
}
