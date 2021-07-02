package io.obswebsocket.community.client.message.response.stream;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStreamStatusResponse extends RequestResponse {

  private Data responseData;

  public GetStreamStatusResponse() {
    super(Request.Type.GetStreamStatus);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean outputActive;
    private Boolean outputTimecode;
    private Integer outputDuration;
  }
}
