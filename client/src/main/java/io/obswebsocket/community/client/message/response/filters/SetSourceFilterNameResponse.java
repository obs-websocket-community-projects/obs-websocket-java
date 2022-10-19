package io.obswebsocket.community.client.message.response.filters;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSourceFilterNameResponse extends RequestResponse<Void> {
  public SetSourceFilterNameResponse() {
    super();
  }
}
