package io.obswebsocket.community.client.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetInputMuteResponse extends RequestResponse {
    public SetInputMuteResponse() {
        super(Request.Type.SetInputMute);
    }
}
