package io.obswebsocket.community.client.message.request.general;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStatsRequest extends Request {

  @Builder
  private GetStatsRequest() {
    super(Type.GetStats);
  }
}