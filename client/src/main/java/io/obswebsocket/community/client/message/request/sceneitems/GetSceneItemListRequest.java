package io.obswebsocket.community.client.message.request.sceneitems;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListRequest extends SceneItemRequest {

  private final Data requestData;

  @Builder
  private GetSceneItemListRequest(String sceneName) {
    super(Type.GetSceneItemList);

    this.requestData = Data.builder().sceneName(sceneName).build();
  }
}
