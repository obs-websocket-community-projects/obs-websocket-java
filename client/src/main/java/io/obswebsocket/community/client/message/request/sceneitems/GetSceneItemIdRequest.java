package io.obswebsocket.community.client.message.request.sceneitems;

import io.obswebsocket.community.client.message.request.Request.Data.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
public class GetSceneItemIdRequest extends SceneItemRequest<GetSceneItemIdRequest.Data> {

  @Builder
  private GetSceneItemIdRequest(@NonNull String sceneName, @NonNull String sourceName, Integer searchOffset) {
    super(Type.GetSceneItemId, Data.builder().sceneName(sceneName).sourceName(sourceName).searchOffset(searchOffset).build());
  }

  @Getter
  @ToString(callSuper = true)
  @SuperBuilder
  static class Data extends SceneItemRequest.Data {
    @NonNull
    private final String sourceName;
    private final Integer searchOffset;
  }
}
