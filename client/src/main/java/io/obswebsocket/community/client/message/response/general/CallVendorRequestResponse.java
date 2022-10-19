package io.obswebsocket.community.client.message.response.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * This class is generated, do not edit!
 */
@Getter
@ToString(
    callSuper = true
)
public class CallVendorRequestResponse extends RequestResponse<CallVendorRequestResponse.SpecificData> {
  @Getter
  @ToString
  @Builder
  public static class SpecificData {
    /**
     * Echoed of `vendorName`
     */
    @NonNull
    private String vendorName;

    /**
     * Echoed of `requestType`
     */
    @NonNull
    private String requestType;

    /**
     * Object containing appropriate response data. {} if request does not provide any response data
     */
    @NonNull
    private JsonObject responseData;
  }
}
