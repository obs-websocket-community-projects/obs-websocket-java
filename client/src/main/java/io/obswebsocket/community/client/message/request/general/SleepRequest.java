package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SleepRequest extends Request<SleepRequest.Data> {
  @Builder
  private SleepRequest(Integer sleepMillis, Integer sleepFrames) {
    super(RequestType.Sleep,
        Data.builder().sleepMillis(sleepMillis).sleepFrames(sleepFrames).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    private final Integer sleepMillis;
    private final Integer sleepFrames;
  }
}
