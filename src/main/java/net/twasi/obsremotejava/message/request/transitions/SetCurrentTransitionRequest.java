package net.twasi.obsremotejava.message.request.transitions;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetCurrentTransitionRequest extends TransitionRequest {
    private final Data requestData;

    @Builder
    private SetCurrentTransitionRequest(String transitionName) {
        super(Type.SetCurrentTransition);

        this.requestData = Data.builder().transitionName(transitionName).build();
    }
}
