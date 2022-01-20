package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleRecordResponse extends RequestResponse {

  private Data responseData;

  public ToggleRecordResponse() {
    super(Request.Data.Type.ToggleRecord);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean outputActive;
  }
}
