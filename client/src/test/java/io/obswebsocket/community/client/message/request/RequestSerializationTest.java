package io.obswebsocket.community.client.message.request;

import static org.assertj.core.api.Assertions.assertThat;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.general.SleepRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
    SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000).build();
    SleepRequest sleepRequest2000 = SleepRequest.builder().sleepMillis(2000).build();
    RequestBatch requestBatch = RequestBatch.builder().haltOnFailure(false)
        .request(sleepRequest1000)
        .request(sleepRequest2000)
        .build();

    String json = "{\n"
        + "  'd': {\n"
        + "    'requestId': '" + requestBatch.getData().getRequestId() + "',\n"
        + "    'haltOnFailure': false,\n"
        + "    'requests': [\n"
        + "      {\n"
        + "        'requestData': {\n"
        + "          'sleepMillis': 1000\n"
        + "        },\n"
        + "        'requestType': 'Sleep',\n"
        + "        'requestId': '" + sleepRequest1000.getRequestId() + "'\n"
        + "      },\n"
        + "      {\n"
        + "        'requestData': {\n"
        + "          'sleepMillis': 2000\n"
        + "        },\n"
        + "        'requestType': 'Sleep',\n"
        + "        'requestId': '" + sleepRequest2000.getRequestId() + "'\n"
        + "      }\n"
        + "    ]\n"
        + "  },\n"
        + "  'op': 8\n"
        + "}";
//    String json = this.readResourceFile("requests/RequestBatch.json");

    assertSerialization(json, requestBatch, false);
  }
}
