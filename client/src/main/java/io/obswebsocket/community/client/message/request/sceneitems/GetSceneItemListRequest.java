// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneItemListRequest extends Request<GetSceneItemListRequest.SpecificData> {
  @Builder
  private GetSceneItemListRequest(String sceneName) {
    super(RequestType.GetSceneItemList, SpecificData.builder().sceneName(sceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;
  }
}
