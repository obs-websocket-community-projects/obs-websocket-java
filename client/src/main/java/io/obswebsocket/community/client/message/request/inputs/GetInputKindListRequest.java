// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputKindListRequest extends Request<GetInputKindListRequest.SpecificData> {
  @Builder
  private GetInputKindListRequest(Boolean unversioned) {
    super(RequestType.GetInputKindList, SpecificData.builder().unversioned(unversioned).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    private Boolean unversioned;
  }
}
