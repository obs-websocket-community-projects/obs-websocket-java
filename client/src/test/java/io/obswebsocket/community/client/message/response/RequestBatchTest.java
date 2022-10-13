package io.obswebsocket.community.client.message.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.Request.Data.Type;
import io.obswebsocket.community.client.message.request.RequestBatch;
import io.obswebsocket.community.client.message.request.general.SleepRequest;
import io.obswebsocket.community.client.message.response.RequestResponse.Status;
import org.junit.jupiter.api.Test;

class RequestBatchTest extends AbstractSerializationTest {

  @Test
  void requestBatch() {
    SleepRequest sleepRequest1000 = SleepRequest.builder().sleepMillis(1000L).build();
    SleepRequest sleepRequest2000 = SleepRequest.builder().sleepMillis(2000L).build();
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

    assertSerialization(json, requestBatch, false);
  }

  @Test
  void requestBatchResponse() {
    String json = "{\n"
        + "  'd': {\n"
        + "    'requestId': '59de683e-9a68-4035-82fa-d747fb9b28fb',\n"
        + "    'results': [\n"
        + "      {\n"
        + "        'requestId': '8cf8fffb-6928-47f0-885d-fd3dee0cd374',\n"
        + "        'requestStatus': {\n"
        + "          'code': 100,\n"
        + "          'result': true\n"
        + "        },\n"
        + "        'requestType': 'Sleep'\n"
        + "      },\n"
        + "      {\n"
        + "        'requestId': 'f3330aea-639c-4b6f-93a0-e87b3c949bd1',\n"
        + "        'requestStatus': {\n"
        + "          'code': 100,\n"
        + "          'result': true\n"
        + "        },\n"
        + "        'requestType': 'Sleep'\n"
        + "      }\n"
        + "    ]\n"
        + "  },\n"
        + "  'op': 9\n"
        + "}";

    RequestBatchResponse response = deserialize(json, RequestBatchResponse.class);
    assertNotNull(response);
    assertNotNull(response.getData());
    assertNotNull(response.getData().getResults());
    assertEquals(2, response.getData().getResults().size());
    assertEquals(RequestResponse.Data.builder()
            .requestId("8cf8fffb-6928-47f0-885d-fd3dee0cd374")
            .requestStatus(Status.builder().code(100).result(true).build())
            .requestType(Type.Sleep).build(),
        response.getData().getResults().get(0));
    assertEquals(RequestResponse.Data.builder()
            .requestId("f3330aea-639c-4b6f-93a0-e87b3c949bd1")
            .requestStatus(Status.builder().code(100).result(true).build())
            .requestType(Type.Sleep).build(),
        response.getData().getResults().get(1));
  }
}
