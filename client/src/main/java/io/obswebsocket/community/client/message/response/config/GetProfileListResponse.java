// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.config;

import io.obswebsocket.community.client.message.response.RequestResponse;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetProfileListResponse extends RequestResponse<GetProfileListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * The name of the current profile
     */
    @NonNull
    private String currentProfileName;

    /**
     * Array of all available profiles
     */
    @NonNull
    @Singular
    private List<String> profiles;
  }
}
