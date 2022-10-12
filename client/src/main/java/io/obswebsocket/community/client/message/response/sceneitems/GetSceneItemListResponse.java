package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneItem;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneItemListResponse extends RequestResponse<GetSceneItemListResponse.Data> {
  public GetSceneItemListResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<SceneItem> sceneItems;
  }
}
