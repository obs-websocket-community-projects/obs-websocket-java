package io.obswebsocket.community.client.message.response.mediainputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class OffsetMediaInputTimecodeResponse extends RequestResponse<OffsetMediaInputTimecodeResponse.Data> {
  public OffsetMediaInputTimecodeResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Long mediaTimestamp;
  }
}
