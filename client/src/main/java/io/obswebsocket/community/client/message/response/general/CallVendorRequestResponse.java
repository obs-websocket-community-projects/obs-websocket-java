// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.response.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class CallVendorRequestResponse extends RequestResponse<CallVendorRequestResponse.SpecificData> {
  /**
   * Echoed of `vendorName`
   *
   * @return the vendorName
   */
  public String getVendorName() {
    return getMessageData().getResponseData().getVendorName();
  }

  /**
   * Echoed of `requestType`
   *
   * @return the requestType
   */
  public String getRequestType() {
    return getMessageData().getResponseData().getRequestType();
  }

  /**
   * Object containing appropriate response data. {} if request does not provide any response data
   *
   * @return the responseData
   */
  public JsonObject getResponseData() {
    return getMessageData().getResponseData().getResponseData();
  }

  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Echoed of `vendorName`
     */
    private String vendorName;

    /**
     * Echoed of `requestType`
     */
    private String requestType;

    /**
     * Object containing appropriate response data. {} if request does not provide any response data
     */
    private JsonObject responseData;
  }
}
