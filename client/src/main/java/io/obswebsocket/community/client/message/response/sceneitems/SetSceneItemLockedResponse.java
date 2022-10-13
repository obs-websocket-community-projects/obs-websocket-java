package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSceneItemLockedResponse extends RequestResponse<Void> {
  public SetSceneItemLockedResponse() {
    super();
  }
}
