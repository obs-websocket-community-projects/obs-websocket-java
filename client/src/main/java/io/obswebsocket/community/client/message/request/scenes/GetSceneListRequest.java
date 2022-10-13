package io.obswebsocket.community.client.message.request.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneListRequest extends Request<Void> {

  @Builder
  private GetSceneListRequest() {
    super(Data.Type.GetSceneList, null);
  }
}
