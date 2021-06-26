package io.obswebsocket.community.test.translator.requestSerializationTests;

import io.obswebsocket.community.message.request.inputs.*;
import io.obswebsocket.community.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class InputsRequestSerializationTest extends AbstractSerializationTest {
    @Test
    void getInputDefaultSettings() {
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

    @Test
    void getInputKindListRequest() {
        GetInputKindListRequest getInputKindListRequest = GetInputKindListRequest.builder()
                .unversioned(false)
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"unversioned\": false\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputKindList\",\n" +
                "\t\"requestId\": " + getInputKindListRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputKindListRequest);
    }

    @Test
    void getInputMonitorTypeRequest() {
        GetInputMonitorTypeRequest getInputMonitorTypeRequest = GetInputMonitorTypeRequest.builder()
                .inputName("input")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputMonitorType\",\n" +
                "\t\"requestId\": " + getInputMonitorTypeRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputMonitorTypeRequest);
    }

    @Test
    void getInputMuteRequest() {
        GetInputMuteRequest getInputMuteRequest = GetInputMuteRequest.builder()
                .inputName("input")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputMute\",\n" +
                "\t\"requestId\": " + getInputMuteRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputMuteRequest);
    }

    @Test
    void getInputSettingsRequest() {
        GetInputSettingsRequest getInputSettingsRequest = GetInputSettingsRequest.builder()
                .inputName("input")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputSettings\",\n" +
                "\t\"requestId\": " + getInputSettingsRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputSettingsRequest);
    }
}
