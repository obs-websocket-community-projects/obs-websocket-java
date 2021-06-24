package io.obswebsocket.community.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetSceneTransitionOverrideResponse extends RequestResponse {
    private Data responseData;

    public GetSceneTransitionOverrideResponse() {
        super(Request.Type.GetSceneTransitionOverride);
    }

    @Getter
    @ToString
    public static class Data {
        private String transitionName;
        private Integer transitionDuration;
    }
}
