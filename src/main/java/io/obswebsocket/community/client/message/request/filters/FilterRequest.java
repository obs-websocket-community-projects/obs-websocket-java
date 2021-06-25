package io.obswebsocket.community.client.message.request.filters;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import io.obswebsocket.community.client.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class FilterRequest extends Request {
    FilterRequest(Type requestType) {
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
