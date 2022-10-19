package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListRequest extends SceneItemRequest<SceneItemRequest.Data> {
  @Builder
  private GetSceneItemListRequest(String sceneName) {
    super(RequestType.GetSceneItemList, Data.builder().sceneName(sceneName).build());
  }
}
