package io.obswebsocket.community.client.message.request.general;

import com.google.gson.JsonObject;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.request.Request.Data.Type;
import io.obswebsocket.community.client.message.request.general.CallVendorRequestRequest.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CallVendorRequestRequest extends Request<Data> {

  @Builder
  private CallVendorRequestRequest(String vendorName, String requestType, JsonObject requestData) {
    super(Type.CallVendorRequest, Data.builder().vendorName(vendorName).requestType(requestType).requestData(requestData).build());
  }

  @Getter
  @ToString
  @Builder
  public static class Data {

    @NonNull
    private final String vendorName;
    @NonNull
    private final String requestType;
    private final JsonObject requestData;
  }

}
