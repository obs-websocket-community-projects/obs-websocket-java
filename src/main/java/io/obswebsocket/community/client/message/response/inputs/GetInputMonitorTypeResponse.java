package io.obswebsocket.community.client.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import io.obswebsocket.community.client.model.Input;

@Getter
@ToString(callSuper = true)
public class GetInputMonitorTypeResponse extends RequestResponse {
    private Data responseData;

    public GetInputMonitorTypeResponse() {
        super(Request.Type.GetInputMonitorType);
    }

    @Getter
    @ToString
    public static class Data {
        private Input.MonitorType monitorType;
    }
}
