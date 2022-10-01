package io.obswebsocket.community.client.message.response.inputs;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputKindListResponse extends RequestResponse<GetInputKindListResponse.Data> {
  public GetInputKindListResponse() {
    super(Request.Data.Type.GetInputKindList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<String> inputKinds;
  }
}
