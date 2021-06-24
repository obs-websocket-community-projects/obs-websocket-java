package io.obswebsocket.community.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class TriggerStudioModeTransitionResponse extends RequestResponse {
    public TriggerStudioModeTransitionResponse() {
        super(Request.Type.TriggerStudioModeTransition);
    }
}
