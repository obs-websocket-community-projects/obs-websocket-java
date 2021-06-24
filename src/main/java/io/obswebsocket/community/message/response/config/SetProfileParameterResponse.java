package io.obswebsocket.community.message.response.config;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.message.request.Request;
import io.obswebsocket.community.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class SetProfileParameterResponse extends RequestResponse {
    public SetProfileParameterResponse() {
        super(Request.Type.SetProfileParameter);
    }
}
