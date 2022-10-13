package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class DeleteSceneTransitionOverrideResponse extends RequestResponse<Void> {
  public DeleteSceneTransitionOverrideResponse() {
    super();
  }
}
