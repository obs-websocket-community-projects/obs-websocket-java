package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneCollection;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListResponse extends RequestResponse {

  private Data responseData;

  public GetSceneCollectionListResponse() {
    super(Request.Data.Type.GetSceneCollectionList);
  }

  @Getter
  @ToString
  public static class Data {

    private List<SceneCollection> sceneCollections;
    private String currentSceneCollectionName;
  }
}
