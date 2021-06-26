package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.transitions.*;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class TransitionsRequestSerializationTest extends AbstractSerializationTest {
    @Test
    void getCurrentTransitionRequest() {
        GetCurrentTransitionRequest getCurrentTransitionRequest = GetCurrentTransitionRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetCurrentTransition\",\n" +
                "\t\"requestId\": " + getCurrentTransitionRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getCurrentTransitionRequest);
    }

    @Test
    void getTransitionListRequest() {
        GetTransitionListRequest getTransitionListRequest = GetTransitionListRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"GetTransitionList\",\n" +
                "\t\"requestId\": " + getTransitionListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getTransitionListRequest);
    }

    @Test
    void releaseTbarRequest() {
        ReleaseTbarRequest releaseTbarRequest = ReleaseTbarRequest.builder().build();

        String json = "{\n" +
                "\t\"requestType\": \"ReleaseTbar\",\n" +
                "\t\"requestId\": " + releaseTbarRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, releaseTbarRequest);
    }

    @Test
    void setCurrentTransitionDurationRequest() {
        SetCurrentTransitionDurationRequest setCurrentTransitionDurationRequest = SetCurrentTransitionDurationRequest.builder()
                .transitionDuration(120)
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"transitionDuration\": 120\n" +
                "\t},\n" +
                "\t\"requestType\": \"SetCurrentTransitionDuration\",\n" +
                "\t\"requestId\": " + setCurrentTransitionDurationRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, setCurrentTransitionDurationRequest);
    }

    @Test
    void setCurrentTransitionRequest() {
        SetCurrentTransitionRequest setCurrentTransitionRequest = SetCurrentTransitionRequest.builder()
                .transitionName("Cool transition")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"transitionName\": \"Cool transition\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"SetCurrentTransition\",\n" +
                "\t\"requestId\": " + setCurrentTransitionRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, setCurrentTransitionRequest);
    }
}
