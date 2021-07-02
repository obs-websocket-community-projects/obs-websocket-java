package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Output;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputListResponse extends RequestResponse {

  private Data responseData;

  public GetOutputListResponse() {
    super(Request.Type.GetOutputList);
  }

  @Getter
  @ToString
  public static class Data {

    private List<Output> outputs;
  }
}
