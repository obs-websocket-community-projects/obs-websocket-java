package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
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
public class GetSceneItemLockedResponse extends RequestResponse<GetSceneItemLockedResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the scene item is locked. `true` for locked, `false` for unlocked
     */
    @NonNull
    private Boolean sceneItemLocked;
  }
}
