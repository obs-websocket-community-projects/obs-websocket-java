package io.obswebsocket.community.client.message.request.mediainputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetMediaInputStatusRequest extends MediaInputRequest {

  private final Data requestData;

  @Builder
  private GetMediaInputStatusRequest(String inputName) {
    super(Request.Data.Type.GetMediaInputStatus);

    this.requestData = Data.builder().inputName(inputName).build();
  }
}