package io.obswebsocket.community.message.request.transitions;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class TriggerStudioModeTransitionRequest extends Request {
    @Builder
    private TriggerStudioModeTransitionRequest() {
        super(Type.TriggerStudioModeTransition);
    }
}
