package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class OffsetMediaInputTimecodeRequest extends MediaInputRequest<OffsetMediaInputTimecodeRequest.Data> {
  @Builder
  private OffsetMediaInputTimecodeRequest(String inputName, Long timestampOffset) {
    super(RequestType.OffsetMediaInputTimecode,
        Data.builder().inputName(inputName).timestampOffset(timestampOffset).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends MediaInputRequest.Data {

    @NonNull
    private final Long timestampOffset;
  }
}
