// @formatter:off
// This class is generated, do not edit!
package io.obswebsocket.community.client.message.request.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(
    callSuper = true
)
public class CallVendorRequestRequest extends Request<CallVendorRequestRequest.SpecificData> {
  @Builder
  private CallVendorRequestRequest(String vendorName, String requestType, JsonObject requestData) {
    super(RequestType.CallVendorRequest, SpecificData.builder().vendorName(vendorName).requestType(requestType).requestData(requestData).build());
  }

  @Getter
  @ToString
  @Builder
  static class SpecificData {
    @NonNull
    private String vendorName;

    @NonNull
    private String requestType;

    private JsonObject requestData;
  }
}
