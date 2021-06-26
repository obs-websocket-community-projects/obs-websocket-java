package io.obswebsocket.community.client.message.request.sources;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
abstract class SourceRequest extends Request {
    SourceRequest(Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    @SuperBuilder
    static class Data {
        @NonNull
        private final String sourceName;
    }
}
