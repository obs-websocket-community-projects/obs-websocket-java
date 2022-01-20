package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
abstract class CurrentSceneResponse extends RequestResponse {

  CurrentSceneResponse(Request.Data.Type requestType) {
    super(requestType);
  }

  @Getter
  @ToString
  static class Data {

    private String sceneName;
  }
}
