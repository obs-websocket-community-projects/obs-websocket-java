// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterResponse extends RequestResponse<GetSourceFilterResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the filter is enabled
     */
    @NonNull
    private Boolean filterEnabled;

    /**
     * Index of the filter in the list, beginning at 0
     */
    @NonNull
    private Number filterIndex;

    /**
     * The kind of filter
     */
    @NonNull
    private String filterKind;

    /**
     * Settings object associated with the filter
     */
    @NonNull
    private JsonObject filterSettings;
  }
}
