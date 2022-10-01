package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneResponse extends CurrentSceneResponse {
  public GetCurrentProgramSceneResponse() {
    super(Request.Data.Type.GetCurrentProgramScene);
  }
}
