// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.transitions;

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
public class GetTransitionKindListResponse extends RequestResponse<GetTransitionKindListResponse.SpecificData> {
  /**
   * Array of transition kinds
   *
   * @return the transitionKinds
   */
  public List<String> getTransitionKinds() {
    return getMessageData().getResponseData().getTransitionKinds();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of transition kinds
     */
    @Singular
    private List<String> transitionKinds;
  }
}
