package io.obswebsocket.community.client.message.response.mediaInputs;

import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SetMediaInputTimecodeResponse extends RequestResponse {
    public SetMediaInputTimecodeResponse() {
        super(Request.Type.SetMediaInputTimecode);
    }
}