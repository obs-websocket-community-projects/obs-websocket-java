package net.twasi.obsremotejava.test.serialization;

import net.twasi.obsremotejava.message.request.RequestBatch;
import net.twasi.obsremotejava.message.request.general.SleepRequest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RequestBatchSerializationTest extends AbstractSerializationTest {
  @Test
  void requestBatch() {
    SleepRequest sleepRequest1000 = new SleepRequest(1000L);
    SleepRequest sleepRequest2000 = new SleepRequest(2000L);
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
