package io.obswebsocket.community.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;
import io.obswebsocket.community.model.Transition;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetTransitionListResponse extends RequestResponse {
    private Data responseData;

    public GetTransitionListResponse() {
        super(Request.Type.GetTransitionList);
    }

    @Getter
    @ToString
    public static class Data {
        private String currentTransitionName;
        private List<Transition> transitions;
    }
}
