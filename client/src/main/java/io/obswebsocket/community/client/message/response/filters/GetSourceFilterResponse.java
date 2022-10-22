// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.filters;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class GetSourceFilterResponse extends RequestResponse<GetSourceFilterResponse.SpecificData> {
  /**
   * Whether the filter is enabled
   *
   * @return the filterEnabled
   */
  public Boolean getFilterEnabled() {
    return getMessageData().getResponseData().getFilterEnabled();
  }

  /**
   * Index of the filter in the list, beginning at 0
   *
   * @return the filterIndex
   */
  public Number getFilterIndex() {
    return getMessageData().getResponseData().getFilterIndex();
  }

  /**
   * The kind of filter
   *
   * @return the filterKind
   */
  public String getFilterKind() {
    return getMessageData().getResponseData().getFilterKind();
  }

  /**
   * Settings object associated with the filter
   *
   * @return the filterSettings
   */
  public JsonObject getFilterSettings() {
    return getMessageData().getResponseData().getFilterSettings();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Whether the filter is enabled
     */
    private Boolean filterEnabled;

    /**
     * Index of the filter in the list, beginning at 0
     */
    private Number filterIndex;

    /**
     * The kind of filter
     */
    private String filterKind;

    /**
     * Settings object associated with the filter
     */
    private JsonObject filterSettings;
  }
}
