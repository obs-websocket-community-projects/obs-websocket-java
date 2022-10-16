package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetPersistentDataResponse extends RequestResponse<GetPersistentDataResponse.Data> {
  public GetPersistentDataResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Object slotValue;
  }
}
