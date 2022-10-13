package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetGroupSceneItemListRequest extends SceneItemRequest<SceneItemRequest.Data> {

  @Builder
  private GetGroupSceneItemListRequest(String sceneName) {
    super(Type.GetGroupSceneItemList, Data.builder().sceneName(sceneName).build());
  }
}
