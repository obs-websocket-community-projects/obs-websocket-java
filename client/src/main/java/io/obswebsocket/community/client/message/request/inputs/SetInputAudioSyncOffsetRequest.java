// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.inputs;

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
public class SetInputAudioSyncOffsetRequest extends Request<SetInputAudioSyncOffsetRequest.SpecificData> {
  @Builder
  private SetInputAudioSyncOffsetRequest(String inputName, Number inputAudioSyncOffset) {
    super(RequestType.SetInputAudioSyncOffset, SpecificData.builder().inputName(inputName).inputAudioSyncOffset(inputAudioSyncOffset).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String inputName;

    @NonNull
    private Number inputAudioSyncOffset;
  }
}
