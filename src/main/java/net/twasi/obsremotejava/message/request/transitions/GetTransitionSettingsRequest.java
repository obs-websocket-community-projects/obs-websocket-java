package net.twasi.obsremotejava.message.request.transitions;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetTransitionSettingsRequest extends TransitionRequest {
    private final Data requestData;

    @Builder
    private GetTransitionSettingsRequest(String transitionName) {
        super(Type.GetTransitionSettings);

        this.requestData = Data.builder().transitionName(transitionName).build();
    }
}
