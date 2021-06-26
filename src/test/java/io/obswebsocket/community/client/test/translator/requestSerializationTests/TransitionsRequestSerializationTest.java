package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.transitions.GetCurrentTransitionRequest;
import io.obswebsocket.community.client.message.request.transitions.GetTransitionListRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class TransitionsRequestSerializationTest extends AbstractSerializationTest {
    @Test
    void getCurrentTransitionRequest() {
        GetCurrentTransitionRequest getCurrentTransitionRequest = GetCurrentTransitionRequest.builder().build();

        String json = "{\n" +
                "\\t\"requestType\": \"GetCurrentTransition\",\n" +
                "\t\"requestId\": " + getCurrentTransitionRequest.getRequestId() + ",\n" +
                "\\t\"messageType\": \"Request\"\n" +
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
}
