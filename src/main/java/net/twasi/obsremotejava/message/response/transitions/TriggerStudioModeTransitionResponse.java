package net.twasi.obsremotejava.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class TriggerStudioModeTransitionResponse extends RequestResponse {
    public TriggerStudioModeTransitionResponse() {
        super(Request.Type.TriggerStudioModeTransition);
    }
}
