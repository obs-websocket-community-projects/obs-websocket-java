package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSpecialInputsResponse extends RequestResponse<GetSpecialInputsResponse.Data> {

  public GetSpecialInputsResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {

    private String desktop1;
    private String desktop2;
    private String mic1;
    private String mic2;
    private String mic3;
    private String mic4;
  }
}
