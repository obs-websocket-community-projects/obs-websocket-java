package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListRequest extends SceneItemRequest {

  private final Data requestData;

  @Builder
  private GetSceneItemListRequest(String sceneName) {
    super(Request.Data.Type.GetSceneItemList);

    this.requestData = Data.builder().sceneName(sceneName).build();
  }
}
