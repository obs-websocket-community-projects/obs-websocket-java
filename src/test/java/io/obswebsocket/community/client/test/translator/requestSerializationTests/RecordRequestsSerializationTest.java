package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.record.GetRecordStatusRequest;
import io.obswebsocket.community.client.message.request.record.StartRecordRequest;
import io.obswebsocket.community.client.message.request.record.StopRecordRequest;
import io.obswebsocket.community.client.message.request.record.ToggleRecordRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class RecordRequestsSerializationTest extends AbstractSerializationTest {
    @Test
    void getRecordStatusRequest() {
        GetRecordStatusRequest getRecordStatusRequest = GetRecordStatusRequest.builder()
                .build();

        String json = "{\n" +
                "\t'requestType': 'GetRecordStatus',\n" +
                "\t'requestId': " + getRecordStatusRequest.getRequestId() + ",\n" +
                "\t'messageType': 'Request'\n" +
                "}";

        assertSerializationAndDeserialization(json, getRecordStatusRequest);
    }

    @Test
    void toggleRecordRequest() {
        ToggleRecordRequest toggleRecordRequest = ToggleRecordRequest.builder()
                .build();

        String json = "{\n" +
                "\t'requestType': 'ToggleRecord',\n" +
                "\t'requestId': " + toggleRecordRequest.getRequestId() + ",\n" +
                "\t'messageType': 'Request'\n" +
                "}";

        assertSerializationAndDeserialization(json, toggleRecordRequest);
    }

    @Test
    void startRecordRequest() {
        StartRecordRequest startRecordRequest = StartRecordRequest.builder()
                .waitForResult(true)
                .build();

        String json = "{\n" +
                "\t'messageType': 'Request',\n" +
                "\t'requestType': 'StartRecord',\n" +
                "\t'requestId': " + startRecordRequest.getRequestId() + ",\n" +
                "\t'requestData': {\n" +
                "\t\t'waitForResult': true\n" +
                "\t}\n" +
                "}";

        assertSerializationAndDeserialization(json, startRecordRequest);
    }

    @Test
    void stopRecordRequest() {
        StopRecordRequest stopRecordRequest = StopRecordRequest.builder()
                .waitForResult(false)
                .build();

        String json = "{\n" +
                "\t'messageType': 'Request',\n" +
                "\t'requestType': 'StopRecord',\n" +
                "\t'requestId': " + stopRecordRequest.getRequestId() + ",\n" +
                "\t'requestData': {\n" +
                "\t\t'waitForResult': false\n" +
                "\t}\n" +
                "}";

        assertSerializationAndDeserialization(json, stopRecordRequest);
    }
}
