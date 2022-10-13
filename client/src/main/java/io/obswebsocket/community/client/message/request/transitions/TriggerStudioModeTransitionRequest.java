package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerStudioModeTransitionRequest extends Request<Void> {

  @Builder
  private TriggerStudioModeTransitionRequest() {
    super(Data.Type.TriggerStudioModeTransition, null);
  }
}
