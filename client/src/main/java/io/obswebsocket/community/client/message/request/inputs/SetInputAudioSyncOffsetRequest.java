package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetInputAudioSyncOffsetRequest extends Request {

  private final Data requestData;

  @Builder
  private SetInputAudioSyncOffsetRequest(String inputName, Integer inputAudioSyncOffset) {
    super(Type.SetInputAudioSyncOffset);

    this.requestData = Data.builder().inputName(inputName)
        .inputAudioSyncOffset(inputAudioSyncOffset).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String inputName;
    @NonNull
    private final Integer inputAudioSyncOffset;
  }
}
