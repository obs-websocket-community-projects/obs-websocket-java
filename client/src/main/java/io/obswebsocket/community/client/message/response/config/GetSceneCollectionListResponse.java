package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListResponse extends RequestResponse<GetSceneCollectionListResponse.Data> {
  public GetSceneCollectionListResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private List<String> sceneCollections;
    private String currentSceneCollectionName;
  }
}
