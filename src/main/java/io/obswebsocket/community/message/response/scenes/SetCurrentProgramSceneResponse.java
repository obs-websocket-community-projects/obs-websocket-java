package io.obswebsocket.community.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetCurrentProgramSceneResponse extends RequestResponse {
    public SetCurrentProgramSceneResponse() {
        super(Request.Type.SetCurrentProgramScene);
    }
}
