package io.obswebsocket.community.message.request.transitions;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionDurationRequest extends Request {
    private final Data requestData;

    @Builder
    private SetCurrentTransitionDurationRequest(Integer transitionDuration) {
        super(Type.SetCurrentTransitionDuration);

        this.requestData = Data.builder().transitionDuration(transitionDuration).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        @NonNull
        private final Integer transitionDuration;
    }
}
