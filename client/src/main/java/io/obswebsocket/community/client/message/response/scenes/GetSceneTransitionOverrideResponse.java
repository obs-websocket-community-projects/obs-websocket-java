package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneTransitionOverrideResponse extends RequestResponse<GetSceneTransitionOverrideResponse.Data> {
  public GetSceneTransitionOverrideResponse() {
    super();
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data {
    private String transitionName;
    private Integer transitionDuration;
  }
}
