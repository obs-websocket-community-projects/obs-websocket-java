package io.obswebsocket.community.client.message.response.mediaInputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class StopMediaInputResponse extends RequestResponse {
    public StopMediaInputResponse() {
        super(Request.Type.StopMediaInput);
    }
}