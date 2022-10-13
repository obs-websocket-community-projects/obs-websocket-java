package io.obswebsocket.community.client.message.response.scenes;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneResponse extends CurrentSceneResponse {
  public GetCurrentPreviewSceneResponse() {
    super();
  }
}
