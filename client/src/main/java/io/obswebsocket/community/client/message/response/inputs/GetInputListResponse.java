// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputListResponse extends RequestResponse<GetInputListResponse.SpecificData> {
  /**
   * Array of inputs
   *
   * @return the inputs
   */
  public List<Input> getInputs() {
    return getMessageData().getResponseData().getInputs();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of inputs
     */
    @Singular
    private List<Input> inputs;
  }
}
