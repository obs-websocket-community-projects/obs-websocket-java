// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.transitions;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneTransitionListRequest extends Request<Void> {
  @Builder
  private GetSceneTransitionListRequest() {
    super(RequestType.GetSceneTransitionList, null);
  }
}
