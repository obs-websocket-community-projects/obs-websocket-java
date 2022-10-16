package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Output;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetOutputListResponse extends RequestResponse<GetOutputListResponse.Data> {
  public GetOutputListResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data { // TODO: The protocol describes this response not to include data

    private List<Output> outputs;
  }
}
