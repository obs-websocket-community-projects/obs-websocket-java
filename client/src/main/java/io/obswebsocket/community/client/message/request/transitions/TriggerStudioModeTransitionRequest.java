package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class TriggerStudioModeTransitionRequest extends Request<Void> {
  @Builder
  private TriggerStudioModeTransitionRequest() {
    super(RequestType.TriggerStudioModeTransition, null);
  }
}
