package io.obswebsocket.community.client.message.response.outputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StartOutputResponse extends RequestResponse {
    public StartOutputResponse() {
        super(Request.Type.StartOutput);
    }
}
