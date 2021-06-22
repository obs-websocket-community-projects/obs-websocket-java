package net.twasi.obsremotejava.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import net.twasi.obsremotejava.message.request.Request;
import net.twasi.obsremotejava.message.response.RequestResponse;
import net.twasi.obsremotejava.model.Transition;

@Getter
@ToString(callSuper = true)
public class GetCurrentTransitionResponse extends RequestResponse {
    private Data responseData;

    public GetCurrentTransitionResponse() {
        super(Request.Type.GetTransitionList);
    }

    @Getter
    @ToString
    public static class Data extends Transition {
        private Double transitionDuration;
        private Double transitionPosition; // optional
    }
}
