package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.SceneItem;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetSceneItemListResponse extends RequestResponse<GetSceneItemListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of scene items in the scene
     */
    @NonNull
    @Singular
    private List<SceneItem> sceneItems;
  }
}
