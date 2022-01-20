package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneTransitionOverrideResponse extends RequestResponse {

  private Data responseData;

  public GetSceneTransitionOverrideResponse() {
    super(Request.Data.Type.GetSceneTransitionOverride);
  }

  @Getter
  @ToString
  public static class Data {

    private String transitionName;
    private Integer transitionDuration;
  }
}
