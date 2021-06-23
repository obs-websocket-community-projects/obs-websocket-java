package net.twasi.obsremotejava.message.request.transitions;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

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
        private final Integer transitionDuration;
    }
}
