package io.obswebsocket.community.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;
import io.obswebsocket.community.model.Input;

import java.util.List;

@Getter
@ToString(callSuper = true)
public class GetInputListResponse extends RequestResponse {
    private Data responseData;

    public GetInputListResponse() {
        super(Request.Type.GetInputList);
    }

    @Getter
    @ToString
    public static class Data {
        private List<Input> inputs;
    }
}
