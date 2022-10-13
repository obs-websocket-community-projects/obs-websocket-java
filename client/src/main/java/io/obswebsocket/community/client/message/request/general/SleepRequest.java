package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SleepRequest extends Request<SleepRequest.Data> {
  @Builder
  private SleepRequest(Long sleepMillis) {
    super(Request.Data.Type.Sleep, Data.builder().sleepMillis(sleepMillis).build());
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final Long sleepMillis;
  }
}
