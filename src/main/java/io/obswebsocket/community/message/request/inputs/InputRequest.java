package io.obswebsocket.community.message.request.inputs;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class InputRequest extends Request {
    InputRequest(Type type) {
        super(type);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String inputName;
    }
}
