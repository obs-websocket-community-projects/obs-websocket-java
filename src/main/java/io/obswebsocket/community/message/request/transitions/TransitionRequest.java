package io.obswebsocket.community.message.request.transitions;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class TransitionRequest extends Request {
    TransitionRequest(Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String transitionName;
    }
}
