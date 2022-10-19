package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleRecordPauseRequest extends Request<Void> {
  @Builder
  private ToggleRecordPauseRequest() {
    super(RequestType.ToggleRecordPause, null);
  }
}
