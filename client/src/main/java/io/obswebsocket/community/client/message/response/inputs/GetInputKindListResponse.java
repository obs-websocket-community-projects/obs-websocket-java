package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputKindListResponse extends RequestResponse {

  private Data responseData;

  public GetInputKindListResponse() {
    super(Request.Data.Type.GetInputKindList);
  }

  @Getter
  @ToString
  public static class Data {

    private List<String> inputKinds;
  }
}
