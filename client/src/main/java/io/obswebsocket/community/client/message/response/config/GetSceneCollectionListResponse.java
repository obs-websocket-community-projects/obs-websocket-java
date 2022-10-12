package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneCollection;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListResponse extends RequestResponse<GetSceneCollectionListResponse.Data> {
  public GetSceneCollectionListResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private List<SceneCollection> sceneCollections;
    private String currentSceneCollectionName;
  }
}
