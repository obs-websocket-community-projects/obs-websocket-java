package io.obswebsocket.community.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetInputKindListResponse extends RequestResponse {
    private Data responseData;

    public GetInputKindListResponse() {
        super(Request.Type.GetInputKindList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<String> inputKinds;
    }
}
