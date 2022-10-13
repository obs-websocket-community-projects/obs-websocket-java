package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemLockedResponse.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemLockedResponse extends RequestResponse<Data> {
  public GetSceneItemLockedResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private Boolean sceneItemLocked;
  }
}
