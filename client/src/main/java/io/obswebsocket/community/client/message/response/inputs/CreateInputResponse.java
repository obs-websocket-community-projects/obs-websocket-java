package io.obswebsocket.community.client.message.response.inputs;

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
public class CreateInputResponse extends RequestResponse<CreateInputResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * ID of the newly created scene item
     */
    @NonNull
    private Number sceneItemId;
  }
}
