// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetMediaInputStatusRequest extends Request<GetMediaInputStatusRequest.SpecificData> {
  @Builder
  private GetMediaInputStatusRequest(String inputName) {
    super(RequestType.GetMediaInputStatus, SpecificData.builder().inputName(inputName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;
  }
}
