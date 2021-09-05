package io.obswebsocket.community.client.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.sceneitems.CreateSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneitems.DuplicateSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemColorRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemEnabledRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemListRequest;
import io.obswebsocket.community.client.message.request.sceneitems.GetSceneItemLockedRequest;
import io.obswebsocket.community.client.message.request.sceneitems.RemoveSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemEnabledRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemIndexRequest;
import io.obswebsocket.community.client.message.request.sceneitems.SetSceneItemLockedRequest;
import io.obswebsocket.community.client.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class SceneItemRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void createSceneItemRequest() {
    CreateSceneItemRequest createSceneItemRequest = CreateSceneItemRequest.builder()
        .sceneName("Scene name")
        .sourceName("Source name")
        .sceneItemEnabled(false)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneName\": \"Scene name\",\n" +
        "\t\t\"sourceName\": \"Source name\",\n" +
        "\t\t\"sceneItemEnabled\": false\n" +
        "\t},\n" +
        "\t\"requestType\": \"CreateSceneItem\",\n" +
        "\t\"requestId\": " + createSceneItemRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, createSceneItemRequest);
  }

  @Test
  void duplicateSceneItemRequest() {
    DuplicateSceneItemRequest duplicateSceneItemRequest = DuplicateSceneItemRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .destinationSceneName("new SceneItem")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"destinationSceneName\": \"new SceneItem\",\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"DuplicateSceneItem\",\n" +
        "\t\"requestId\": " + duplicateSceneItemRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, duplicateSceneItemRequest);
  }

  @Test
  void getSceneItemColorRequest() {
    GetSceneItemColorRequest getSceneItemColorRequest = GetSceneItemColorRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetSceneItemColor\",\n" +
        "\t\"requestId\": " + getSceneItemColorRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemColorRequest);
  }

  @Test
  void getSceneItemEnabledRequest() {
    GetSceneItemEnabledRequest getSceneItemEnabledRequest = GetSceneItemEnabledRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetSceneItemEnabled\",\n" +
        "\t\"requestId\": " + getSceneItemEnabledRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemEnabledRequest);
  }

  @Test
  void getSceneItemListRequest() {
    GetSceneItemListRequest getSceneItemListRequest = GetSceneItemListRequest.builder()
        .sceneName("Scene name")
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetSceneItemList\",\n" +
        "\t\"requestId\": " + getSceneItemListRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemListRequest);
  }

  @Test
  void getSceneItemLockedRequest() {
    GetSceneItemLockedRequest getSceneItemLockedRequest = GetSceneItemLockedRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"GetSceneItemLocked\",\n" +
        "\t\"requestId\": " + getSceneItemLockedRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemLockedRequest);
  }

  @Test
  void removeSceneItemRequest() {
    RemoveSceneItemRequest removeSceneItemRequest = RemoveSceneItemRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"RemoveSceneItem\",\n" +
        "\t\"requestId\": " + removeSceneItemRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, removeSceneItemRequest);
  }

  @Test
  void setSceneItemEnabledRequest() {
    SetSceneItemEnabledRequest setSceneItemEnabledRequest = SetSceneItemEnabledRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .sceneItemEnabled(true)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemEnabled\": true,\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetSceneItemEnabled\",\n" +
        "\t\"requestId\": " + setSceneItemEnabledRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, setSceneItemEnabledRequest);
  }

  @Test
  void setSceneItemIndexRequest() {
    SetSceneItemIndexRequest setSceneItemIndexRequest = SetSceneItemIndexRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .sceneItemIndex(2)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemIndex\": 2,\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetSceneItemIndex\",\n" +
        "\t\"requestId\": " + setSceneItemIndexRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, setSceneItemIndexRequest);
  }

  @Test
  void setSceneItemLockedRequest() {
    SetSceneItemLockedRequest setSceneItemLockedRequest = SetSceneItemLockedRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .sceneItemLocked(false)
        .build();

    String json = "{\n" +
        "\t\"requestData\": {\n" +
        "\t\t\"sceneItemLocked\": false,\n" +
        "\t\t\"sceneItemId\": 1234,\n" +
        "\t\t\"sceneName\": \"Scene name\"\n" +
        "\t},\n" +
        "\t\"requestType\": \"SetSceneItemLocked\",\n" +
        "\t\"requestId\": " + setSceneItemLockedRequest.getRequestId() + ",\n" +
        "\t\"messageType\": \"Request\"\n" +
        "}";

    assertSerializationAndDeserialization(json, setSceneItemLockedRequest);
  }
}
