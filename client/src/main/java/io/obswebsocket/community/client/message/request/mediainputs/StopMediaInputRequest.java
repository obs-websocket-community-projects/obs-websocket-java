package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopMediaInputRequest extends MediaInputRequest<MediaInputRequest.Data> {
  @Builder
  private StopMediaInputRequest(String inputName) {
    super(Request.Data.Type.StopMediaInput, Data.builder().inputName(inputName).build());
  }
}
