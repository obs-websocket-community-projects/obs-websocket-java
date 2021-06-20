package net.twasi.obsremotejava.message.request.sources;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
abstract class SourceRequest extends Request {
    public SourceRequest(Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final String sourceName;
    }
}
