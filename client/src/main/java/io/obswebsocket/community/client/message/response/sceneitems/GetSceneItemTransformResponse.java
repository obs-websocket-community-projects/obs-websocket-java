package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.message.response.sceneitems.GetSceneItemLockedResponse.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemTransformResponse extends RequestResponse<Data> {
  public GetSceneItemTransformResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    //TODO: Find actual type
    private Object sceneItemTransform;
  }
}
