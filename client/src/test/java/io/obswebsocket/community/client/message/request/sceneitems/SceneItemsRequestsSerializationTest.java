package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.model.SceneItem;
import io.obswebsocket.community.client.model.SceneItem.BlendMode;
import org.junit.jupiter.api.Test;

public class SceneItemsRequestsSerializationTest extends AbstractSerializationTest {

  @Test
  void createSceneItemRequest() {
    CreateSceneItemRequest createSceneItemRequest = CreateSceneItemRequest.builder()
                                                                          .sceneName("Scene name")
                                                                          .sourceName("Source name")
                                                                          .sceneItemEnabled(false)
                                                                          .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneName': 'Scene name',\n" +
            "\t\t'sourceName': 'Source name',\n" +
            "\t\t'sceneItemEnabled': false\n" +
            "\t},\n" +
            "\t'requestType': 'CreateSceneItem',\n" +
            "\t'requestId': " + createSceneItemRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
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

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'destinationSceneName': 'new SceneItem',\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'DuplicateSceneItem',\n" +
            "\t'requestId': " + duplicateSceneItemRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, duplicateSceneItemRequest);
  }

  @Test
  void getSceneItemEnabledRequest() {
    GetSceneItemEnabledRequest getSceneItemEnabledRequest = GetSceneItemEnabledRequest.builder()
                                                                                      .sceneName("Scene name")
                                                                                      .sceneItemId(1234)
                                                                                      .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'GetSceneItemEnabled',\n" +
            "\t'requestId': " + getSceneItemEnabledRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getSceneItemEnabledRequest);
  }

  @Test
  void getSceneItemListRequest() {
    GetSceneItemListRequest getSceneItemListRequest = GetSceneItemListRequest.builder()
                                                                             .sceneName("Scene name")
                                                                             .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'GetSceneItemList',\n" +
            "\t'requestId': " + getSceneItemListRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getSceneItemListRequest);
  }

  @Test
  void getSceneItemIdRequest() {
    GetSceneItemIdRequest getSceneItemIdRequest = GetSceneItemIdRequest.builder()
        .sceneName("Scene name")
        .sourceName("Source name")
        .searchOffset(3)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneName': 'Scene name',\n" +
        "\t\t'sourceName': 'Source name',\n" +
        "\t\t'searchOffset': 3\n" +
        "\t},\n" +
        "\t'requestType': 'GetSceneItemId',\n" +
        "\t'requestId': " + getSceneItemIdRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemIdRequest);
  }

  @Test
  void getGroupSceneItemListRequest() {
    GetGroupSceneItemListRequest getGroupSceneItemListRequest = GetGroupSceneItemListRequest.builder()
        .sceneName("Scene name")
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'GetGroupSceneItemList',\n" +
        "\t'requestId': " + getGroupSceneItemListRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getGroupSceneItemListRequest);
  }

  @Test
  void getSceneItemTransformRequest() {
    GetSceneItemTransformRequest getSceneItemTransformRequest = GetSceneItemTransformRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneItemId': 1234,\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'GetSceneItemTransform',\n" +
        "\t'requestId': " + getSceneItemTransformRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemTransformRequest);
  }

  @Test
  void setSceneItemTransformRequest() {
    SetSceneItemTransformRequest setSceneItemTransformRequest = SetSceneItemTransformRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .sceneItemTransform(SceneItem.Transform.builder()
            .rotation(45f)
            .build())
        .build();

    String json = "{"
        + "\t'd':"
        + "\t{\n"
        + "\t\t'requestData': {\n"
        + "\t\t\t'sceneItemId': 1234,\n"
        + "\t\t\t'sceneName': 'Scene name',\n"
        + "\t\t\t'sceneItemTransform': {\n"
        + "\t\t\t\t'rotation': 45\n"
        + "\t\t\t}\n"
        + "\t\t},\n"
        + "\t\t'requestType': 'SetSceneItemTransform',\n"
        + "\t\t'requestId': '" + setSceneItemTransformRequest.getRequestId() + "'\n"
        + "\t},\n"
        + "\t'op': 6\n"
        + "}";

    assertSerializationAndDeserialization(json, setSceneItemTransformRequest);
  }

  @Test
  void getSceneItemLockedRequest() {
    GetSceneItemLockedRequest getSceneItemLockedRequest = GetSceneItemLockedRequest.builder()
                                                                                   .sceneName("Scene name")
                                                                                   .sceneItemId(1234)
                                                                                   .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'GetSceneItemLocked',\n" +
            "\t'requestId': " + getSceneItemLockedRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, getSceneItemLockedRequest);
  }

  @Test
  void removeSceneItemRequest() {
    RemoveSceneItemRequest removeSceneItemRequest = RemoveSceneItemRequest.builder()
                                                                          .sceneName("Scene name")
                                                                          .sceneItemId(1234)
                                                                          .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'RemoveSceneItem',\n" +
            "\t'requestId': " + removeSceneItemRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
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

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneItemEnabled': true,\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'SetSceneItemEnabled',\n" +
            "\t'requestId': " + setSceneItemEnabledRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, setSceneItemEnabledRequest);
  }

  @Test
  void getSceneItemIndexRequest() {
    GetSceneItemIndexRequest getSceneItemIndexRequest = GetSceneItemIndexRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneItemId': 1234,\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'GetSceneItemIndex',\n" +
        "\t'requestId': " + getSceneItemIndexRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemIndexRequest);
  }

  @Test
  void setSceneItemIndexRequest() {
    SetSceneItemIndexRequest setSceneItemIndexRequest = SetSceneItemIndexRequest.builder()
                                                                                .sceneName("Scene name")
                                                                                .sceneItemId(1234)
                                                                                .sceneItemIndex(2)
                                                                                .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneItemIndex': 2,\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'SetSceneItemIndex',\n" +
            "\t'requestId': " + setSceneItemIndexRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, setSceneItemIndexRequest);
  }

  @Test
  void getSceneItemBlendModeRequest() {
    GetSceneItemBlendModeRequest getSceneItemBlendModeRequest = GetSceneItemBlendModeRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneItemId': 1234,\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'GetSceneItemBlendMode',\n" +
        "\t'requestId': " + getSceneItemBlendModeRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, getSceneItemBlendModeRequest);
  }

  @Test
  void setSceneItemBlendModeRequest() {
    SetSceneItemBlendModeRequest setSceneItemBlendModeRequest = SetSceneItemBlendModeRequest.builder()
        .sceneName("Scene name")
        .sceneItemId(1234)
        .sceneItemBlendMode(BlendMode.ADDITIVE)
        .build();

    String json = "{'d': {\n" +
        "\t'requestData': {\n" +
        "\t\t'sceneItemBlendMode': 'OBS_BLEND_ADDITIVE',\n" +
        "\t\t'sceneItemId': 1234,\n" +
        "\t\t'sceneName': 'Scene name'\n" +
        "\t},\n" +
        "\t'requestType': 'SetSceneItemBlendMode',\n" +
        "\t'requestId': " + setSceneItemBlendModeRequest.getRequestId() + "},\n" +
        "\t'op': 6\n" +
        "}";

    assertSerializationAndDeserialization(json, setSceneItemBlendModeRequest);
  }

  @Test
  void setSceneItemLockedRequest() {
    SetSceneItemLockedRequest setSceneItemLockedRequest = SetSceneItemLockedRequest.builder()
                                                                                   .sceneName("Scene name")
                                                                                   .sceneItemId(1234)
                                                                                   .sceneItemLocked(false)
                                                                                   .build();

    String json = "{'d': {\n" +
            "\t'requestData': {\n" +
            "\t\t'sceneItemLocked': false,\n" +
            "\t\t'sceneItemId': 1234,\n" +
            "\t\t'sceneName': 'Scene name'\n" +
            "\t},\n" +
            "\t'requestType': 'SetSceneItemLocked',\n" +
            "\t'requestId': " + setSceneItemLockedRequest.getRequestId() + "},\n" +
            "\t'op': 6\n" +
            "}";

    assertSerializationAndDeserialization(json, setSceneItemLockedRequest);
  }
}
