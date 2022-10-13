package io.obswebsocket.community.client.message.response.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneResponse extends CurrentSceneResponse {
  public GetCurrentProgramSceneResponse() {
    super();
  }
}
