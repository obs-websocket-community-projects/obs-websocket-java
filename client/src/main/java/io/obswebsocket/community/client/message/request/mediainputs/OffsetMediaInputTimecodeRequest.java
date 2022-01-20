package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class OffsetMediaInputTimecodeRequest extends MediaInputRequest {

  private final Data requestData;

  @Builder
  private OffsetMediaInputTimecodeRequest(String inputName, Long timestampOffset) {
    super(Request.Data.Type.OffsetMediaInputTimecode);

    this.requestData = Data.builder().inputName(inputName).timestampOffset(timestampOffset).build();
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    @NonNull
    private final Long timestampOffset;
  }
}