// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.filters;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterListResponse extends RequestResponse<GetSourceFilterListResponse.SpecificData> {
  /**
   * Array of filters
   *
   * @return the filters
   */
  public List<Filter> getFilters() {
    return getMessageData().getResponseData().getFilters();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of filters
     */
    @Singular
    private List<Filter> filters;
  }
}
