package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSceneIndexResponse extends RequestResponse {

  public SetSceneIndexResponse() {
    super(Request.Type.SetSceneIndex);
  }
}
