package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class SetMediaInputTimecodeRequest extends MediaInputRequest<SetMediaInputTimecodeRequest.Data> {
  @Builder
  private SetMediaInputTimecodeRequest(String inputName, Long mediaTimestamp) {
    super(Request.Data.Type.SetMediaInputTimecode, Data.builder().inputName(inputName).mediaTimestamp(mediaTimestamp).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    @NonNull
    private final Long mediaTimestamp;
  }
}
