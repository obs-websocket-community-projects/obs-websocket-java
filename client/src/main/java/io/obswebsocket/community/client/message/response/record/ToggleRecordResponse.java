package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class ToggleRecordResponse extends RequestResponse<ToggleRecordResponse.Data> {
  public ToggleRecordResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean outputActive;
  }
}
