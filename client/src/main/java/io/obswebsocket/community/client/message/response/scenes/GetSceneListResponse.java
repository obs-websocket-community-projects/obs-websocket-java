package io.obswebsocket.community.client.message.response.scenes;

import java.util.List;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Scene;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneListResponse extends RequestResponse<GetSceneListResponse.Data> {
  public GetSceneListResponse() {
    super(Request.Data.Type.GetSceneList);
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  public static class Data {
    private String currentProgramSceneName;
    private String currentPreviewSceneName;
    private List<Scene> scenes;
  }
}
