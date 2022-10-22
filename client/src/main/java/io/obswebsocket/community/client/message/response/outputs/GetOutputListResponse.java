// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Output;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetOutputListResponse extends RequestResponse<GetOutputListResponse.SpecificData> {
  /**
   * Array of outputs
   *
   * @return the outputs
   */
  public List<Output> getOutputs() {
    return getMessageData().getResponseData().getOutputs();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of outputs
     */
    @Singular
    private List<Output> outputs;
  }
}
