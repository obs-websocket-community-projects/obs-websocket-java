package io.obswebsocket.community.client.message.response.sceneitems;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneItem;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListResponse extends RequestResponse<GetSceneItemListResponse.Data> {
  public GetSceneItemListResponse() {
    super(Request.Data.Type.GetSceneItemList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<SceneItem> sceneItems;
  }
}
