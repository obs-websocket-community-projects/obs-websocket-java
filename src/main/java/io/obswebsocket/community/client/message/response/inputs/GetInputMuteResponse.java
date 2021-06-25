package io.obswebsocket.community.client.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetInputMuteResponse extends RequestResponse {
    private Data responseData;

    public GetInputMuteResponse() {
        super(Request.Type.GetInputMute);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean inputMuted;
    }
}
