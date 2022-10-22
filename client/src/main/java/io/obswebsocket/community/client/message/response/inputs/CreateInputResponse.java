// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class CreateInputResponse extends RequestResponse<CreateInputResponse.SpecificData> {
  /**
   * ID of the newly created scene item
   *
   * @return the sceneItemId
   */
  public Number getSceneItemId() {
    return getMessageData().getResponseData().getSceneItemId();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * ID of the newly created scene item
     */
    private Number sceneItemId;
  }
}
