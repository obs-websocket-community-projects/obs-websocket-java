package io.obswebsocket.community.client.message.response.inputs;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class GetInputVolumeResponse extends RequestResponse {
    private Data responseData;

    public GetInputVolumeResponse() {
        super(Request.Type.GetInputVolume);
    }

    @Getter
    @ToString
    public static class Data {
        private float inputVolumeDb;
        private float inputVolumeMul;
    }
}
