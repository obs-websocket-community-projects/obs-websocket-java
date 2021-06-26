package io.obswebsocket.community.client.message.response.transitions;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class TriggerStudioModeTransitionResponse extends RequestResponse {
    public TriggerStudioModeTransitionResponse() {
        super(Request.Type.TriggerStudioModeTransition);
    }
}
