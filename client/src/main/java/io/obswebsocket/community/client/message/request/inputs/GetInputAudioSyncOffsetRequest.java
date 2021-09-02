package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetInputAudioSyncOffsetRequest extends Request {

  private final Data requestData;

  @Builder
  private GetInputAudioSyncOffsetRequest(String inputName) {
    super(Type.GetInputAudioSyncOffset);

    this.requestData = Data.builder().inputName(inputName).build();
  }

  @Getter
  @ToString
  @Builder
  static class Data {

    @NonNull
    private final String inputName;
  }
}
