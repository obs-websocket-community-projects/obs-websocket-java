package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.scenes.GetCurrentPreviewSceneRequest;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentPreviewSceneResponse extends RequestResponse<GetCurrentPreviewSceneRequest.Data> {
  public GetCurrentPreviewSceneResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String currentPreviewSceneName;
  }
}
