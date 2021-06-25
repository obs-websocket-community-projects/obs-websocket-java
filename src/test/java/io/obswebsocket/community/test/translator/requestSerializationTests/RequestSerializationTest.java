package io.obswebsocket.community.test.translator.requestSerializationTests;

import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.request.RequestBatch;
import io.obswebsocket.community.message.request.general.SleepRequest;
import io.obswebsocket.community.test.translator.AbstractSerializationTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestSerializationTest extends AbstractSerializationTest {
    @Test
    void notOrUnknownRequest() {
        assertThat(deserializeTo("[]", Request.class)).isNull();
        assertThat(deserializeTo("{}", Request.class)).isNull();
        assertThat(deserializeTo("{'messageType':'Request'}", Request.class)).isNull();
        assertThat(deserializeTo("{'messageType':'Request', 'requestType':'SomethingGibberish'}", Request.class)).isNull();
    }

    @Test
    void requestBatch() {
        SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();
        SleepRequest sleepRequest2000 = SleepRequest.builder().sleepMillis(2000L).build();
        RequestBatch requestBatch = RequestBatch.builder().haltOnFailure(false).requests(Arrays.asList(sleepRequest1000, sleepRequest2000)).build();

        String json = "{\n" +
                "  \"requestId\": " + requestBatch.getRequestId() + ",\n" +
                "  \"haltOnFailure\": false,\n" +
                "  \"requests\": [\n" +
                "    {\n" +
                "      \"requestData\": {\n" +
                "        \"sleepMillis\": 1000\n" +
                "      },\n" +
                "      \"requestType\": \"Sleep\",\n" +
                "      \"requestId\": " + sleepRequest1000.getRequestId() + ",\n" +
                "      \"messageType\": \"Request\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"requestData\": {\n" +
                "        \"sleepMillis\": 2000\n" +
                "      },\n" +
                "      \"requestType\": \"Sleep\",\n" +
                "      \"requestId\": " + sleepRequest2000.getRequestId() + ",\n" +
                "      \"messageType\": \"Request\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"messageType\": \"RequestBatch\"\n" +
                "}";

        assertSerializationAndDeserialization(json, requestBatch);
    }
}
