// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.sceneitems;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSceneItemIndexResponse extends RequestResponse<GetSceneItemIndexResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Index position of the scene item
     */
    @NonNull
    private Number sceneItemIndex;
  }
}
