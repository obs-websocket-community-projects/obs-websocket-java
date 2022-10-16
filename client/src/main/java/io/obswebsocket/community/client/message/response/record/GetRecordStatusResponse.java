package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetRecordStatusResponse extends RequestResponse<GetRecordStatusResponse.Data> {
  public GetRecordStatusResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Boolean outputActive;
    private Boolean outputPaused;
    private String outputTimecode;
    private Long outputDuration;
    private Long outputBytes;
  }
}
