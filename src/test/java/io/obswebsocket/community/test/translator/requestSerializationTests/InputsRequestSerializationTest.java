package io.obswebsocket.community.test.translator.requestSerializationTests;

import io.obswebsocket.community.message.request.inputs.*;
import io.obswebsocket.community.model.Input;
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

    @Test
    void getInputTracksRequest() {
        GetInputTracksRequest getInputTracksRequest = GetInputTracksRequest.builder()
                .inputName("input")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputTracks\",\n" +
                "\t\"requestId\": " + getInputTracksRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputTracksRequest);
    }

    @Test
    void getInputVolumeRequest() {
        GetInputVolumeRequest getInputVolumeRequest = GetInputVolumeRequest.builder()
                .inputName("input")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"GetInputVolume\",\n" +
                "\t\"requestId\": " + getInputVolumeRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getInputVolumeRequest);
    }

    @Test
    void setInputMonitorTypeRequest() {
        SetInputMonitorTypeRequest setInputMonitorTypeRequest = SetInputMonitorTypeRequest.builder()
                .inputName("input")
                .monitorType(Input.MonitorType.MONITOR_AND_OUTPUT)
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"monitorType\": \"monitorAndOutput\",\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"SetInputMonitorType\",\n" +
                "\t\"requestId\": " + setInputMonitorTypeRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, setInputMonitorTypeRequest);
    }

    @Test
    void setInputMuteRequest() {
        SetInputNameRequest setInputNameRequest = SetInputNameRequest.builder()
                .inputName("input")
                .newInputName("awesome new input name")
                .build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"newInputName\": \"awesome new input name\",\n" +
                "\t\t\"inputName\": \"input\"\n" +
                "\t},\n" +
                "\t\"requestType\": \"SetInputName\",\n" +
                "\t\"requestId\": " + setInputNameRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, setInputNameRequest);
    }
}
