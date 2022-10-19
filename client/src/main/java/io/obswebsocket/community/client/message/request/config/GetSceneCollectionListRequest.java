package io.obswebsocket.community.client.message.request.config;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListRequest extends Request<Void> {
  @Builder
  private GetSceneCollectionListRequest() {
    super(RequestType.GetSceneCollectionList, null);
  }
}
