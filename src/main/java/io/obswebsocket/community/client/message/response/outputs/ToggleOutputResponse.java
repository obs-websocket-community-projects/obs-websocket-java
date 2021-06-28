package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ToggleOutputResponse extends RequestResponse {
    private Data responseData;

    public ToggleOutputResponse() {
        super(Request.Type.ToggleOutput);
    }

    @Getter
    @ToString
    public static class Data {
        private Boolean outputActive;
    }
}
