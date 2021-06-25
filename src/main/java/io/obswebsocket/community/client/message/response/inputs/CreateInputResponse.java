package io.obswebsocket.community.client.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class CreateInputResponse extends RequestResponse {
    private Data responseData;

    public CreateInputResponse() {
        super(Request.Type.CreateInput);
    }

    @Getter
    @ToString
    public static class Data {
        private Integer sceneItemId;
    }
}
