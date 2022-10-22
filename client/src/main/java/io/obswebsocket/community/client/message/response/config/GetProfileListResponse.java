// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

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
public class GetProfileListResponse extends RequestResponse<GetProfileListResponse.SpecificData> {
  /**
   * The name of the current profile
   *
   * @return the currentProfileName
   */
  public String getCurrentProfileName() {
    return getMessageData().getResponseData().getCurrentProfileName();
  }

  /**
   * Array of all available profiles
   *
   * @return the profiles
   */
  public List<String> getProfiles() {
    return getMessageData().getResponseData().getProfiles();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The name of the current profile
     */
    private String currentProfileName;

    /**
     * Array of all available profiles
     */
    @Singular
    private List<String> profiles;
  }
}
