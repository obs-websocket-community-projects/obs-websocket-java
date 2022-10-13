package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetSceneItemTransformResponse extends RequestResponse<Void> {

  public SetSceneItemTransformResponse() {
    super();
  }

}
