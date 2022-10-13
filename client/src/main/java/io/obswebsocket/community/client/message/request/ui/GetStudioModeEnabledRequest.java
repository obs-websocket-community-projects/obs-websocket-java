package io.obswebsocket.community.client.message.request.ui;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetStudioModeEnabledRequest extends Request<Void> {

  @Builder
  private GetStudioModeEnabledRequest() {
    super(Data.Type.GetStudioModeEnabled, null);
  }
}
