package io.obswebsocket.community.client.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.config.CreateSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.GetPersistentDataRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileListRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileParameterRequest;
import io.obswebsocket.community.client.message.request.config.GetSceneCollectionListRequest;
import io.obswebsocket.community.client.message.request.config.GetVideoSettingsRequest;
import io.obswebsocket.community.client.message.request.config.RemoveSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetCurrentSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetPersistentDataRequest;
import io.obswebsocket.community.client.message.request.config.SetProfileParameterRequest;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class ConfigRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void getPersistentDataRequest() {
    GetPersistentDataRequest getPersistentDataRequest = GetPersistentDataRequest
        .builder().realm("Realm").slotName("Slot Name").build();

    String json = "{\n" +
        "\t'messageType': 'Request'\n," +
        "\t'requestType': 'GetPersistentData',\n" +
        "\t'requestId': " + getPersistentDataRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'realm': 'Realm',\n" +
        "\t\t'slotName': 'Slot Name'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getPersistentDataRequest);
  }

  @Test
  void setPersistentDataRequest() {
    SetPersistentDataRequest setPersistentDataRequest = SetPersistentDataRequest
        .builder().realm("Realm").slotName("Slot Name").slotValue("value").build();

    String json = "{\n" +
        "\t'messageType': 'Request'\n," +
        "\t'requestType': 'SetPersistentData',\n" +
        "\t'requestId': " + setPersistentDataRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'realm': 'Realm'\n," +
        "\t\t'slotName': 'Slot Name',\n" +
        "\t\t'slotValue': 'value'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setPersistentDataRequest);
  }

  @Test
  void createSceneCollectionRequest() {
    CreateSceneCollectionRequest createSceneCollectionRequest = CreateSceneCollectionRequest
        .builder().sceneCollectionName("Collection Name").build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetCurrentSceneCollection',\n" +
        "\t'requestId': " + createSceneCollectionRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneCollectionName': 'Collection Name'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, createSceneCollectionRequest);
  }

  @Test
  void getProfileListRequest() {
    GetProfileListRequest getProfileListRequest = GetProfileListRequest.builder().build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetProfileList',\n" +
        "\t'requestId': " + getProfileListRequest.getRequestId() + "\n" +
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
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetProfileParameter',\n" +
        "\t'requestId': " + getProfileParameterRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'parameterCategory': 'Category Name',\n" +
        "\t\t'parameterName': 'Parameter Name'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, getProfileParameterRequest);
  }

  @Test
  void getSceneCollectionListRequest() {
    GetSceneCollectionListRequest getSceneCollectionListRequest = GetSceneCollectionListRequest
        .builder().build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetSceneCollectionList',\n" +
        "\t'requestId': " + getSceneCollectionListRequest.getRequestId() + "\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneCollectionListRequest);
  }

  @Test
  void getVideoSettingsRequest() {
    GetVideoSettingsRequest getVideoSettingsRequest = GetVideoSettingsRequest.builder().build();

    String json = "{\n" +
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'GetVideoSettings',\n" +
        "\t'requestId': " + getVideoSettingsRequest.getRequestId() + "\n" +
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
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'RemoveSceneCollection',\n" +
        "\t'requestId': " + removeSceneCollectionRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneCollectionName': 'Collection Name'\n" +
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
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetCurrentSceneCollection',\n" +
        "\t'requestId': " + setCurrentSceneCollectionRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneCollectionName': 'Collection Name'\n" +
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
        "\t'messageType': 'Request',\n" +
        "\t'requestType': 'SetProfileParameter',\n" +
        "\t'requestId': " + setProfileParameterRequest.getRequestId() + ",\n" +
        "\t'requestData': {\n" +
        "\t\t'parameterCategory': 'Category',\n" +
        "\t\t'parameterName': 'Param',\n" +
        "\t\t'parameterValue': 'new Value'\n" +
        "\t}\n" +
        "}";

    assertSerializationAndDeserialization(json, setProfileParameterRequest);
  }
}
