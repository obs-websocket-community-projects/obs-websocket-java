package io.obswebsocket.community.client.message.response.filters;

import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Filter;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterListResponse extends RequestResponse<GetSourceFilterListResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Array of filters
     */
    @NonNull
    @Singular
    private List<Filter> filters;
  }
}
