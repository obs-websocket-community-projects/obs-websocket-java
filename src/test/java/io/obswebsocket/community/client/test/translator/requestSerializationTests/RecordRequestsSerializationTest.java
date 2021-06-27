package io.obswebsocket.community.client.test.translator.requestSerializationTests;

import io.obswebsocket.community.client.message.request.record.GetRecordStatusRequest;
import io.obswebsocket.community.client.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

public class RecordRequestsSerializationTest extends AbstractSerializationTest {
    @Test
    void getRecordStatusRequest() {
        GetRecordStatusRequest getRecordStatusRequest = GetRecordStatusRequest.builder()
                .build();

        String json = "{\n" +
                "\t\"requestType\": \"GetRecordStatus\",\n" +
                "\t\"requestId\": " + getRecordStatusRequest.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        assertSerializationAndDeserialization(json, getRecordStatusRequest);
    }
}
