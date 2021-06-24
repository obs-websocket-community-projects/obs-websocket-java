package io.obswebsocket.community.message.request.scenes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetSceneListRequest extends Request {
    @Builder
    private GetSceneListRequest() {
        super(Type.GetSceneList);
    }
}
