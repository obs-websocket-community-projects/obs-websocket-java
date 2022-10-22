// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetInputKindListResponse extends RequestResponse<GetInputKindListResponse.SpecificData> {
  /**
   * Array of input kinds
   *
   * @return the inputKinds
   */
  public List<String> getInputKinds() {
    return getMessageData().getResponseData().getInputKinds();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of input kinds
     */
    @Singular
    private List<String> inputKinds;
  }
}
