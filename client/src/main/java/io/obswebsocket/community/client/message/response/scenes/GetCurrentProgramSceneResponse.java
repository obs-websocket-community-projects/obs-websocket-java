package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneResponse extends RequestResponse<GetCurrentProgramSceneResponse.Data> {
  public GetCurrentProgramSceneResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String currentProgramSceneName;
  }
}
