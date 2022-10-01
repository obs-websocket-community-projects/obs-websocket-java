package io.obswebsocket.community.client.message.response.config;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneCollection;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListResponse extends RequestResponse<GetSceneCollectionListResponse.Data> {
  public GetSceneCollectionListResponse() {
    super(Request.Data.Type.GetSceneCollectionList);
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<SceneCollection> sceneCollections;
    private String currentSceneCollectionName;
  }
}
