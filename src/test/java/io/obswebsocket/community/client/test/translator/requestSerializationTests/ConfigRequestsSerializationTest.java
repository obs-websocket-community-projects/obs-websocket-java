package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.config.CreateSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileListRequest;
import io.obswebsocket.community.client.message.request.config.GetProfileParameterRequest;
import io.obswebsocket.community.client.message.request.config.GetSceneCollectionListRequest;
import io.obswebsocket.community.client.message.request.config.GetVideoSettingsRequest;
import io.obswebsocket.community.client.message.request.config.RemoveSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetCurrentSceneCollectionRequest;
import io.obswebsocket.community.client.message.request.config.SetProfileParameterRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class ConfigRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void createSceneCollectionRequest() {
    CreateSceneCollectionRequest createSceneCollectionRequest = CreateSceneCollectionRequest
        .builder().sceneCollectionName("Collection Name").build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneCollectionName\": \"Collection Name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetCurrentSceneCollection\",\n" +
        "\t\"requestId\": " + createSceneCollectionRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, createSceneCollectionRequest);
  }

  @Test
  void getProfileListRequest() {
    GetProfileListRequest getProfileListRequest = GetProfileListRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetProfileList\",\n" +
        "\t\"requestId\": " + getProfileListRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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
        "\t\"requestData\": {\n" +
        "\t\t\"parameterCategory\": \"Category Name\",\n" +
        "\t\t\"parameterName\": \"Parameter Name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetProfileParameter\",\n" +
        "\t\"requestId\": " + getProfileParameterRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getProfileParameterRequest);
  }

  @Test
  void getSceneCollectionListRequest() {
    GetSceneCollectionListRequest getSceneCollectionListRequest = GetSceneCollectionListRequest
        .builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetSceneCollectionList\",\n" +
        "\t\"requestId\": " + getSceneCollectionListRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneCollectionListRequest);
  }

  @Test
  void getVideoSettingsRequest() {
    GetVideoSettingsRequest getVideoSettingsRequest = GetVideoSettingsRequest.builder().build();

    String json = "{\n" +
        "\t\"requestType\": \"GetVideoSettings\",\n" +
        "\t\"requestId\": " + getVideoSettingsRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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
        "\t\"requestData\": {\n" +
        "\t\t\"sceneCollectionName\": \"Collection Name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"RemoveSceneCollection\",\n" +
        "\t\"requestId\": " + removeSceneCollectionRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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
        "\t\"requestData\": {\n" +
        "\t\t\"sceneCollectionName\": \"Collection Name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetCurrentSceneCollection\",\n" +
        "\t\"requestId\": " + setCurrentSceneCollectionRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
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
        "\t\"requestData\": {\n" +
        "\t\t\"parameterCategory\": \"Category\",\n" +
        "\t\t\"parameterName\": \"Param\",\n" +
        "\t\t\"parameterValue\": \"new Value\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetProfileParameter\",\n" +
        "\t\"requestId\": " + setProfileParameterRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, setProfileParameterRequest);
  }
}
