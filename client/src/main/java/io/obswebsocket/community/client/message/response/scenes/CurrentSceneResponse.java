package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public abstract class CurrentSceneResponse extends RequestResponse<CurrentSceneResponse.Data> {

  @Getter
  @ToString
  public static class Data {

    private String sceneName;
  }
}
