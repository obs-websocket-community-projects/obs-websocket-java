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
public class GetSceneItemIdRequest extends Request<GetSceneItemIdRequest.SpecificData> {
  @Builder
  private GetSceneItemIdRequest(String sceneName, String sourceName, Number searchOffset) {
    super(RequestType.GetSceneItemId, SpecificData.builder().sceneName(sceneName).sourceName(sourceName).searchOffset(searchOffset).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;

    @NonNull
    private String sourceName;

    private Number searchOffset;
  }
}
