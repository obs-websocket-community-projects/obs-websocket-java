package io.obswebsocket.community.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
abstract class CurrentSceneResponse extends RequestResponse {
    CurrentSceneResponse(Request.Type requestType) {
        super(requestType);
    }

    @Getter
    @ToString
    static class Data {
        private String sceneName;
    }
}
