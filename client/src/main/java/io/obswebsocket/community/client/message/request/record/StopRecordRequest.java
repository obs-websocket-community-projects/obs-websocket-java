package io.obswebsocket.community.client.message.request.record;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class StopRecordRequest extends Request<Void> {
  @Builder
  private StopRecordRequest() {
    super(RequestType.StopRecord, null);
  }
}
