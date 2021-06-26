package io.obswebsocket.community.client.message.response.inputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;
import lombok.Getter;
import lombok.ToString;

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
