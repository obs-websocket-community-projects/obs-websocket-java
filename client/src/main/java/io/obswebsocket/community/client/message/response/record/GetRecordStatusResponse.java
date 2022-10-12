package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetRecordStatusResponse extends RequestResponse<GetRecordStatusResponse.Data> {
  public GetRecordStatusResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean outputActive;
    private Boolean outputPaused;
    private Long outputTimecode;
    private Long outputDuration;
  }
}
