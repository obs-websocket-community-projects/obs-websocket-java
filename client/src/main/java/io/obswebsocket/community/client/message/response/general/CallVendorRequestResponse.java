package io.obswebsocket.community.client.message.response.general;

import io.obswebsocket.community.client.message.request.general.CallVendorRequestRequest;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CallVendorRequestResponse extends RequestResponse<CallVendorRequestRequest.Data> {
}
