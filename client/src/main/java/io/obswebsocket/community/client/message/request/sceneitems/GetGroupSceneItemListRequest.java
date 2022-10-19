package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetGroupSceneItemListRequest extends Request<GetGroupSceneItemListRequest.SpecificData> {
  @Builder
  private GetGroupSceneItemListRequest(String sceneName) {
    super(RequestType.GetGroupSceneItemList, SpecificData.builder().sceneName(sceneName).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String sceneName;
  }
}
