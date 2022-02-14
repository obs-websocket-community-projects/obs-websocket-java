package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetInputAudioSyncOffsetRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private SetInputAudioSyncOffsetRequest(String inputName, Long inputAudioSyncOffset) {
    super(Type.SetInputAudioSyncOffset);

    this.requestData = Data.builder().inputName(inputName)
        .inputAudioSyncOffset(inputAudioSyncOffset).build();
  }

  @Getter
  @ToString
  @SuperBuilder
  static class Data extends InputRequest.Data {
    @NonNull
    private final Long inputAudioSyncOffset;
  }
}
