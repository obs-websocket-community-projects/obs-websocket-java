package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.sceneItems.CreateSceneItemRequest;
import io.obswebsocket.community.client.message.request.sceneItems.DuplicateSceneItemRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceActiveRequest;
import io.obswebsocket.community.client.message.request.sources.GetSourceScreenshotRequest;
import io.obswebsocket.community.client.message.request.sources.SaveSourceScreenshotRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class SceneItemRequestsSerializationTest extends AbstractSerializationTest {
    @Test
    void createSceneItemRequest() {
        CreateSceneItemRequest createSceneItemRequest = CreateSceneItemRequest.builder()
                .sceneName("Scene name")
                .inputName("Input name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputName\": \"Input name\",\n" +
                "\t\t\"sceneName\": \"Scene name\"\n" +
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
}
