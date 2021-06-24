package io.obswebsocket.community.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;
import io.obswebsocket.community.model.Transition;

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
