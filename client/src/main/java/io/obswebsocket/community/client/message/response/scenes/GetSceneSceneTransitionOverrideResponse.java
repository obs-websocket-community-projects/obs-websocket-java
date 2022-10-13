package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneSceneTransitionOverrideResponse extends RequestResponse<GetSceneSceneTransitionOverrideResponse.Data> {
  public GetSceneSceneTransitionOverrideResponse() {
    super();
  }

  @Getter
  @ToString
  public static class Data {
    private String transitionName;
    private Integer transitionDuration;
  }
}
