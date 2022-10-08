package io.obswebsocket.community.client.message.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.general.SleepRequest;

public class RequestSerializationTest extends AbstractSerializationTest {

  @Test
  void notOrUnknownRequest() {
    Assertions.assertThat(deserializeTo("[]", Request.class)).isNull();
    assertThat(deserializeTo("{}", Request.class)).isNull();
    assertThat(deserializeTo("{'op':6}", Request.class)).isNull();
    assertThat(deserializeTo("{'op':6, 'requestType':'SomethingGibberish'}",
            Request.class)).isNull();
  }

  @Test
  void requestBatch() {
    SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();
    SleepRequest sleepRequest2000 = SleepRequest.builder().sleepMillis(2000L).build();
    RequestBatch requestBatch = RequestBatch.builder().haltOnFailure(false)
                                            .requests(Arrays.asList(sleepRequest1000, sleepRequest2000)).build();

    String json = "{\n" +
            "  'requestId': " + requestBatch.getRequestId() + ",\n" +
            "  'haltOnFailure': false,\n" +
            "  'requests': [\n" +
            "    {'d': {\n" +
            "      'requestData': {\n" +
            "        'sleepMillis': 1000\n" +
            "      },\n" +
            "      'requestType': 'Sleep',\n" +
            "      'requestId': " + sleepRequest1000.getRequestId() + "},\n" +
            "      'op': 6\n" +
            "    },\n" +
            "    {'d': {\n" +
            "      'requestData': {\n" +
            "        'sleepMillis': 2000\n" +
            "      },\n" +
            "      'requestType': 'Sleep',\n" +
            "      'requestId': " + sleepRequest2000.getRequestId() + "},\n" +
            "      'op': 6\n" +
            "    }\n" +
            "  ],\n" +
            "  'op': 8\n" +
            "}";

    assertSerializationAndDeserialization(json, requestBatch);
  }
}
