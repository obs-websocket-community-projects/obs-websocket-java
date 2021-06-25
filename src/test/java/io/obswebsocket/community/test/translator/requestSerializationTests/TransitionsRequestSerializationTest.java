package io.obswebsocket.community.test.translator.requestSerializationTests;

import io.obswebsocket.community.message.request.transitions.GetCurrentTransitionRequest;
import io.obswebsocket.community.test.translator.AbstractSerializationTest;
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
}
