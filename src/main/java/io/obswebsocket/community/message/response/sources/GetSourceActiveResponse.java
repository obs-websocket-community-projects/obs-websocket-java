package io.obswebsocket.community.message.response.sources;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSourceActiveResponse extends RequestResponse {
    private Data responseData;

    public GetSourceActiveResponse() {
        super(Request.Type.GetSourceActive);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean videoActive;
        private Boolean videoShowing;
    }
}
