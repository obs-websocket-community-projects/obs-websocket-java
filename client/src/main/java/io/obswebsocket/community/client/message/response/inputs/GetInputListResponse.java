package io.obswebsocket.community.client.message.response.inputs;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetInputListResponse extends RequestResponse<GetInputListResponse.Data> {
  public GetInputListResponse() {
    super(Request.Data.Type.GetInputList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<Input> inputs;
  }
}
