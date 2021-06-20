package net.twasi.obsremotejava.test.translator;

import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.request.general.SleepRequest;
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
    void sleepRequest() {
        SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();

        String json = "{\n" +
                "\t\"requestData\": {\n" +
                "\t\t\"sleepMillis\": 1000\n" +
                "\t},\n" +
                "\t\"requestType\": \"Sleep\",\n" +
                "\t\"requestId\": " + sleepRequest1000.getRequestId() + ",\n" +
                "\t\"messageType\": \"Request\"\n" +
                "}";

        Request request = deserializeTo(json, Request.class);
        assertThat(request).isNotNull();
        assertThat(request.getRequestType()).isEqualTo(Request.Type.Sleep);
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
