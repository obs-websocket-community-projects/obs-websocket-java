package io.obswebsocket.community.message.request.inputs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;

@Getter
@ToString(callSuper = true)
public class GetInputKindListRequest extends Request {
    private final Data requestData;

    @Builder
    private GetInputKindListRequest(Boolean unversioned) {
        super(Type.GetInputKindList);

        this.requestData = Data.builder().unversioned(unversioned).build();
    }

    @Getter
    @ToString
    @Builder
    static class Data {
        private final Boolean unversioned;
    }
}
