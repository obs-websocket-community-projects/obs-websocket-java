package net.twasi.obsremotejava.message.request.transitions;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;

@Getter
@ToString(callSuper = true)
public class TriggerStudioModeTransitionRequest extends Request {
    @Builder
    private TriggerStudioModeTransitionRequest() {
        super(Type.TriggerStudioModeTransition);
    }
}
