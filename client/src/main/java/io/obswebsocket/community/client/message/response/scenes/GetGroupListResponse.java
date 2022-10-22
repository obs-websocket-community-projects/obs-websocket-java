// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.scenes;

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
public class GetGroupListResponse extends RequestResponse<GetGroupListResponse.SpecificData> {
  /**
   * Array of group names
   *
   * @return the groups
   */
  public List<String> getGroups() {
    return getMessageData().getResponseData().getGroups();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of group names
     */
    @Singular
    private List<String> groups;
  }
}
