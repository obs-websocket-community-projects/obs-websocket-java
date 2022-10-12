package io.obswebsocket.community.client.message.request.inputs;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSpecialInputNamesRequest extends Request<Void> {

  @Builder
  private GetSpecialInputNamesRequest() {
    super(Data.Type.GetSpecialInputNames, null);
  }
}
