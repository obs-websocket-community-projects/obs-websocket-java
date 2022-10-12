package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSceneNameResponse extends RequestResponse<Void> {
  public SetSceneNameResponse() {
    super(Request.Data.Type.SetSceneName);
  }
}
