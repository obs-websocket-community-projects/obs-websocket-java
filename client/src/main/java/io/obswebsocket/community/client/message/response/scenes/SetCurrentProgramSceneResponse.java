package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentProgramSceneResponse extends RequestResponse<Void> {
  public SetCurrentProgramSceneResponse() {
    super(Request.Data.Type.SetCurrentProgramScene);
  }
}
