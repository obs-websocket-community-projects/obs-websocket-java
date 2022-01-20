package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSceneItemEnabledResponse extends RequestResponse {

  public SetSceneItemEnabledResponse() {
    super(Request.Data.Type.SetSceneItemEnabled);
  }
}
