package io.obswebsocket.community.client.message.response.outputs;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Output;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetOutputListResponse extends RequestResponse<GetOutputListResponse.Data> {
  public GetOutputListResponse() {
    super(Request.Data.Type.GetOutputList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<Output> outputs;
  }
}
