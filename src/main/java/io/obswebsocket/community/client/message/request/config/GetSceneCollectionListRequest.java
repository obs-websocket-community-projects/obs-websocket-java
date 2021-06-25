package io.obswebsocket.community.client.message.request.config;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetSceneCollectionListRequest extends Request {
    @Builder
    private GetSceneCollectionListRequest() {
        super(Type.GetSceneCollectionList);
    }
}
