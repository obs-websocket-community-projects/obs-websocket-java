package io.obswebsocket.community.client.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioSyncOffsetRequest extends InputRequest {

  private final Data requestData;

  @Builder
  private GetInputAudioSyncOffsetRequest(String inputName) {
    super(Type.GetInputAudioSyncOffset);

    this.requestData = Data.builder().inputName(inputName).build();
  }
}
