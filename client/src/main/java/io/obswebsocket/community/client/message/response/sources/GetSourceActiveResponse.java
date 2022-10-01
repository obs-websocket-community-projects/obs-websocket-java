package io.obswebsocket.community.client.message.response.sources;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveResponse extends RequestResponse<GetSourceActiveResponse.Data> {
  public GetSourceActiveResponse() {
    super(Request.Data.Type.GetSourceActive);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean videoActive;
    private Boolean videoShowing;
  }
}
