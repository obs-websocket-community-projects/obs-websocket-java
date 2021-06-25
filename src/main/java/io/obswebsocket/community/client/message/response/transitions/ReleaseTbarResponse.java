package io.obswebsocket.community.client.message.response.transitions;

import lombok.Getter;
import lombok.ToString;
import io.obswebsocket.community.client.message.request.Request;
import io.obswebsocket.community.client.message.response.RequestResponse;

@Getter
@ToString(callSuper = true)
public class ReleaseTbarResponse extends RequestResponse {
    public ReleaseTbarResponse() {
        super(Request.Type.ReleaseTbar);
    }
}
