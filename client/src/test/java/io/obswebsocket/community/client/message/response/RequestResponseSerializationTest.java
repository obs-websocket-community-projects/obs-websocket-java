package io.obswebsocket.community.client.message.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.RequestType;
import io.obswebsocket.community.client.message.response.RequestResponse.Status;
import io.obswebsocket.community.client.message.response.scenes.GetCurrentProgramSceneResponse;
import org.junit.jupiter.api.Test;

class RequestResponseSerializationTest extends AbstractSerializationTest {

  @Test
  void requestBatchResponse() {

    String json = this.readResourceFile("responses/RequestBatchResponse.json");

    Object sceneData = deserialize("{'sceneName': 'Test'}", GetCurrentProgramSceneResponse.Data.class);

    RequestBatchResponse response = deserialize(json, RequestBatchResponse.class);
    assertNotNull(response);
    assertNotNull(response.getData());
    assertNotNull(response.getData().getResults());
    assertEquals(2, response.getData().getResults().size());
    assertEquals(RequestResponse.Data.builder()
            .requestId("8cf8fffb-6928-47f0-885d-fd3dee0cd374")
            .requestStatus(Status.builder().code(100).result(true).build())
            .requestType(RequestType.Sleep).build().toString(),
        response.getData().getResults().get(0).toString());
    assertEquals(RequestResponse.Data.builder()
            .requestId("f3330aea-639c-4b6f-93a0-e87b3c949bd1")
            .requestStatus(Status.builder().code(100).result(true).build())
            .requestType(RequestType.GetCurrentProgramScene)
            .responseData(sceneData)
            .build().toString(),
        response.getData().getResults().get(1).toString());
  }
}
