package io.obswebsocket.community.test.translator.requestSerializationTests;

import io.obswebsocket.community.message.request.inputs.GetInputDefaultSettingsRequest;
import io.obswebsocket.community.message.request.inputs.GetInputListRequest;
import io.obswebsocket.community.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class InputsRequestSerializationTest extends AbstractSerializationTest {
    @Test
    void createInputRequest() {
        GetInputDefaultSettingsRequest getInputDefaultSettingsRequest = GetInputDefaultSettingsRequest.builder()
                .inputKind("input kind")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputKind\": \"input kind\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputDefaultSettings\",\n" +
                "\t\"requestId\": " + getInputDefaultSettingsRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputDefaultSettingsRequest);
    }

    @Test
    void getInputKindListRequest() {
        GetInputListRequest getInputListRequest = GetInputListRequest.builder()
                .inputKind("input kind")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputKind\": \"input kind\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputList\",\n" +
                "\t\"requestId\": " + getInputListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputListRequest);
    }

    @Test
    void getInputListRequest() {
        GetInputListRequest getInputListRequest = GetInputListRequest.builder()
                .inputKind("input kind")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputKind\": \"input kind\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputList\",\n" +
                "\t\"requestId\": " + getInputListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputListRequest);
    }
}
