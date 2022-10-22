// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class SleepRequest extends Request<SleepRequest.SpecificData> {
  @Builder
  private SleepRequest(Number sleepMillis, Number sleepFrames) {
    super(RequestType.Sleep, SpecificData.builder().sleepMillis(sleepMillis).sleepFrames(sleepFrames).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    private Number sleepMillis;

    private Number sleepFrames;
  }
}
