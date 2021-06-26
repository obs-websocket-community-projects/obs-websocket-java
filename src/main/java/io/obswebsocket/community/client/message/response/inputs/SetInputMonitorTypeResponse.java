package io.obswebsocket.community.client.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetInputMonitorTypeResponse extends RequestResponse {
    public SetInputMonitorTypeResponse() {
        super(Request.Type.SetInputMonitorType);
    }
}
