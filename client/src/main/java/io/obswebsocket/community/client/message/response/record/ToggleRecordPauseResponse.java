package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleRecordPauseResponse extends RequestResponse {

  private Data responseData;

  public ToggleRecordPauseResponse() {
    super(Request.Data.Type.ToggleRecordPause);
  }

  @Getter
  @ToString
  public static class Data {

    private Boolean outputPaused;
  }
}
