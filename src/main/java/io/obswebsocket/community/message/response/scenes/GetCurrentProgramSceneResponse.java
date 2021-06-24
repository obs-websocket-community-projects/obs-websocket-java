package io.obswebsocket.community.message.response.scenes;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneResponse extends CurrentSceneResponse {
    private Data responseData;

    public GetCurrentProgramSceneResponse() {
        super(Request.Type.GetCurrentProgramScene);
    }
}
