package io.obswebsocket.community.client.message.response.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class ToggleRecordPauseResponse extends RequestResponse<Void> {
  public ToggleRecordPauseResponse() {
    super(Request.Data.Type.ToggleRecordPause);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private Boolean outputPaused;
  }
}
