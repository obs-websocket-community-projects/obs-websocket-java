package io.obswebsocket.community.message.response.general;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetStudioModeEnabledResponse extends RequestResponse {
    private Data responseData;

    public GetStudioModeEnabledResponse() {
        super(Request.Type.GetStudioModeEnabled);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean studioModeEnabled;
    }
}
