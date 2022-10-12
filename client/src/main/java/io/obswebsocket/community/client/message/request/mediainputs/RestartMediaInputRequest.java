package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RestartMediaInputRequest extends MediaInputRequest<MediaInputRequest.Data> {

  @Builder
  private RestartMediaInputRequest(String inputName) {
    super(Request.Data.Type.RestartMediaInput, Data.builder().inputName(inputName).build());
  }
}
