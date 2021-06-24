package io.obswebsocket.community.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class ToggleInputMuteResponse extends RequestResponse {
    private Data responseData;

    public ToggleInputMuteResponse() {
        super(Request.Type.ToggleInputMute);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean inputMuted;
    }
}
