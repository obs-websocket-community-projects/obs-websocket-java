package io.obswebsocket.community.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetTransitionSettingsResponse extends RequestResponse {
    public SetTransitionSettingsResponse() {
        super(Request.Type.SetTransitionSettings);
    }
}
