package io.obswebsocket.community.client.message.response.scenes;

import io.obswebsocket.community.client.message.request.Request;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class GetCurrentProgramSceneResponse extends CurrentSceneResponse {
    private Data responseData;

    public GetCurrentProgramSceneResponse() {
        super(Request.Type.GetCurrentProgramScene);
    }
}
