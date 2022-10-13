package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleRecordResponse extends RequestResponse<ToggleRecordResponse.Data> {
  public ToggleRecordResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Boolean outputActive;
  }
}
