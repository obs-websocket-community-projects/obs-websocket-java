package io.obswebsocket.community.client.message.request;

import static org.assertj.core.api.Assertions.assertThat;

import io.obswebsocket.community.client.message.AbstractSerializationTest;
import io.obswebsocket.community.client.message.request.general.SleepRequest;
import java.util.HashMap;
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

    HashMap<String, String> vars = new HashMap<>();
    vars.put("rbid", requestBatch.getData().getRequestId());
    vars.put("rbr1id", sleepRequest1000.getRequestId());
    vars.put("rbr2id", sleepRequest2000.getRequestId());
    String json = this.readResourceFile("requests/RequestBatch.json", vars);

    assertSerialization(json, requestBatch, false);
  }
}
