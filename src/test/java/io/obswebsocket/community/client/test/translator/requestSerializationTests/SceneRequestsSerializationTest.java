package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.scenes.*;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class SceneRequestsSerializationTest extends AbstractSerializationTest {
    @Test
    void createSceneRequest() {
        CreateSceneRequest createSceneRequest = CreateSceneRequest.builder()
                .sceneName("Scene name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"sceneName\": \"Scene name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"CreateScene\",\n" +
                "\t\"requestId\": " + createSceneRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, createSceneRequest);
    }

    @Test
    void deleteSceneTransitionOverrideRequest() {
        DeleteSceneTransitionOverrideRequest deleteSceneTransitionOverrideRequest = DeleteSceneTransitionOverrideRequest.builder()
                .sceneName("Scene name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"sceneName\": \"Scene name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"DeleteSceneTransitionOverride\",\n" +
                "\t\"requestId\": " + deleteSceneTransitionOverrideRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, deleteSceneTransitionOverrideRequest);
    }

    @Test
    void getCurrentPreviewSceneRequest() {
        GetCurrentPreviewSceneRequest getCurrentPreviewSceneRequest = GetCurrentPreviewSceneRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetCurrentPreviewScene\",\n" +
                "\t\"requestId\": " + getCurrentPreviewSceneRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getCurrentPreviewSceneRequest);
    }


    @Test
    void getCurrentProgramSceneRequest() {
        GetCurrentProgramSceneRequest getCurrentProgramSceneRequest = GetCurrentProgramSceneRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetCurrentProgramScene\",\n" +
                "\t\"requestId\": " + getCurrentProgramSceneRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getCurrentProgramSceneRequest);
    }

    @Test
    void getSceneListRequest() {
        GetSceneListRequest getSceneListRequest = GetSceneListRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetSceneList\",\n" +
                "\t\"requestId\": " + getSceneListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getSceneListRequest);
    }

    @Test
    void getSceneTransitionOverrideRequest() {
        GetSceneTransitionOverrideRequest getSceneTransitionOverrideRequest = GetSceneTransitionOverrideRequest.builder()
                .sceneName("Scene name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"sceneName\": \"Scene name\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetSceneTransitionOverride\",\n" +
                "\t\"requestId\": " + getSceneTransitionOverrideRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getSceneTransitionOverrideRequest);
    }
}
